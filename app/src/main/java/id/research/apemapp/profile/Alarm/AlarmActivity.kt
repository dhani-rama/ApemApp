package id.research.apemapp.profile.Alarm

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityAlarmBinding
import java.util.*


class AlarmActivity : AppCompatActivity() {

    private lateinit var alarmBinding: ActivityAlarmBinding
    private lateinit var mPicker: MaterialTimePicker
    private lateinit var mCalender: Calendar
    private lateinit var mAlarmManager: AlarmManager
    private lateinit var mPendingIntent: PendingIntent
    private lateinit var mNotification: Uri
    private lateinit var mMediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        alarmBinding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(alarmBinding.root)

        createNotificationChannel()

        alarmBinding.btnSelectedTime.setOnClickListener {
            showTimePicker()
        }

        alarmBinding.btnSetAlarm.setOnClickListener {
            setAlarm()
        }

        alarmBinding.btnCancelAlarm.setOnClickListener {
            cancelAlarm()
        }

    }

    private fun cancelAlarm() {

        mAlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)


        mPendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        mAlarmManager.cancel(mPendingIntent)

        Toasty.info(this, "Alarm Dibatalkan", Toast.LENGTH_LONG).show()

    }

    private fun setAlarm() {

        mAlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)

        mPendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        mAlarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP, mCalender.timeInMillis,
            AlarmManager.INTERVAL_DAY, mPendingIntent
        )

        Toasty.success(this, "Pengaturan Alarm Berhasil", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTimePicker() {
        mPicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        mPicker.show(supportFragmentManager, "A-PEM APP")

        mPicker.addOnPositiveButtonClickListener {
            if (mPicker.hour > 12) {
                alarmBinding.tvSelectedTime.text =
                    String.format("%02d", mPicker.hour - 12) + " : " + String.format(
                        "%02d",
                        mPicker.minute
                    ) + " PM"
            }
            else{
                alarmBinding.tvSelectedTime.text = String.format("%02d", mPicker.hour) + " : " + String.format(
                    "%02d",
                    mPicker.minute
                ) + " AM"
            }

            mCalender = Calendar.getInstance()
            mCalender[Calendar.HOUR_OF_DAY] = mPicker.hour
            mCalender[Calendar.MINUTE] = mPicker.minute
            mCalender[Calendar.SECOND] = 0
            mCalender[Calendar.MILLISECOND] = 0
        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "A-PEM APP Reminder"
            val description = "Fitur untuk setting alarm belajar"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("A-PEM APP", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)
        }
    }
}