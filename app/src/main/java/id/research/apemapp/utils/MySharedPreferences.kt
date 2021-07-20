package id.research.apemapp.utils

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(mContext: Context)  {

    companion object{
        const val MURID_PREF = "MURID_PREF"
    }

    private val mSharedPreferences = mContext.getSharedPreferences(MURID_PREF, 0)

    fun setValue(key: String, value: String){
        val editor: SharedPreferences.Editor = mSharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getValue(key: String): String?{
        return mSharedPreferences.getString(key, "")
    }

}