package id.research.apemapp.home.OnlineCompiler

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import de.markusressel.kodehighlighter.language.java.JavaRuleBook
import es.dmoral.toasty.Toasty
import id.research.apemapp.R
import id.research.apemapp.databinding.FragmentEditorCodeBinding
import id.research.apemapp.retrofit.APIClient
import id.research.apemapp.utils.MySharedPreferences
import kotlinx.android.synthetic.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EditorCodeFragment : Fragment() {

    private lateinit var editorCodeBinding: FragmentEditorCodeBinding
    private lateinit var myPreferences: MySharedPreferences
    private var api = APIClient.instance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        editorCodeBinding = FragmentEditorCodeBinding.inflate(inflater, container, false)
        return editorCodeBinding.root
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myPreferences = MySharedPreferences(this.requireActivity())

        with(editorCodeBinding.etInputCode.codeEditorView.codeEditText) {
            setTextColor(Color.WHITE)
            setPadding(16, 0, 0, 0)
            setText("#include <iostream>\n\n\nusing namespace std;\n\n//fungsi main\nint main(){\n\n//isi program disini\n\n\nreturn 0;\n}")
        }

        editorCodeBinding.etInputCode.codeEditorView.languageRuleBook = JavaRuleBook()

        editorCodeBinding.btnCheck.setOnClickListener {
            compile()
        }
    }

    private fun compile() {
        val execute =
            api!!.aPI.execute(PostData(editorCodeBinding.etInputCode.codeEditorView.codeEditText.text.toString(), editorCodeBinding.etInputStdin.text.toString()))

        execute!!.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                try {
                    if (response.isSuccessful) {
                        val jsonObject = JSONObject(response.body())
                        val output = jsonObject.getString("output")
                        val memory = jsonObject.getString("memory")
                        val cpuTime = jsonObject.getString("cpuTime")

                        val bundle = Bundle()

                        with(bundle) {
                            putString(BottomSheetFragment.EXTRA_OUTPUT, output)
                            putString(BottomSheetFragment.EXTRA_MEMORY, memory)
                            putString(BottomSheetFragment.EXTRA_CPU, cpuTime)
                        }

                        findNavController().navigate(
                            R.id.action_editorCodeFragment_to_bottomSheetFragment, bundle
                        )
                    } else {
                        Toasty.error(
                            this@EditorCodeFragment.requireActivity(),
                            response.errorBody().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Toasty.error(
                        this@EditorCodeFragment.requireActivity(),
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}