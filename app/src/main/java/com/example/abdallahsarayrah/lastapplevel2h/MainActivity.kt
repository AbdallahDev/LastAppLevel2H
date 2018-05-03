package com.example.abdallahsarayrah.lastapplevel2h

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)

            val notification = NotificationCompat.Builder(this).setDefaults(Notification.DEFAULT_ALL).setContentTitle("Notification Title")
                    .setContentText("Notification Text").setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentIntent(PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT))
            
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, notification.build())
        }
    }
}
