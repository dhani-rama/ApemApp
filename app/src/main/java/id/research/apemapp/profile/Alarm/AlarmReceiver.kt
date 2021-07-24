package id.research.apemapp.profile.Alarm

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.research.apemapp.R

class AlarmReceiver : BroadcastReceiver() {

    private lateinit var mNotification: Uri
    private lateinit var mMediaPlayer: MediaPlayer

    override fun onReceive(context: Context?, intent: Intent?) {

        mNotification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        mMediaPlayer = MediaPlayer.create(context, mNotification)
        mMediaPlayer.start()

        val destination = Intent(context, DestinationActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, 0,destination,0)



        val builder = NotificationCompat.Builder(context!!, "A-PEM APP")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("A-PEM APP Alarm Manager")
            .setContentText("Mari Belajar Sayang :)")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(123, builder.build())
    }

}