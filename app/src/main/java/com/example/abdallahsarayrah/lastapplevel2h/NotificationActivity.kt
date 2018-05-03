package com.example.abdallahsarayrah.lastapplevel2h

import android.app.Notification
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification.*
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        button2.setOnClickListener {
            // prepare intent which is triggered if the
            // notification is selected
            val intent = Intent(this, Main2Activity::class.java)

            // use System.currentTimeMillis() to have a unique ID for the pending intent
            val pIntent = PendingIntent.getActivity(this, System.currentTimeMillis().toInt(), intent, 0)

            // build notification
            // the addAction re-use the same intent to keep the example short
            val n = Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject")
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentIntent(pIntent)
                    .setAutoCancel(true)
                    .addAction(R.mipmap.ic_launcher_round, "Call", pIntent)
                    .addAction(R.mipmap.ic_launcher_round, "More", pIntent)
                    .addAction(R.mipmap.ic_launcher_round, "And more", pIntent).build()

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(0, n)
        }
    }
}
