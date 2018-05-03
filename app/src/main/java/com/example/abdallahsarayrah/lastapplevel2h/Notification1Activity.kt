package com.example.abdallahsarayrah.lastapplevel2h

import android.app.Notification
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification1.*
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent


class Notification1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification1)

        button3.setOnClickListener {

            val intent = Intent(this, Main2Activity::class.java)
            val pIntent = PendingIntent.getActivity(this, System.currentTimeMillis().toInt(), intent, 0)

            val longText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."


            val noti = Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject").setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentIntent(pIntent)
                    .addAction(R.mipmap.ic_launcher_round, "Call", pIntent)
                    .addAction(R.mipmap.ic_launcher_round, "More", pIntent)
                    .addAction(R.mipmap.ic_launcher_round, "And more", pIntent).setStyle(Notification.BigTextStyle().bigText(longText)).build()


            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // hide the notification after its selected
            noti.flags = noti.flags or Notification.FLAG_AUTO_CANCEL

            notificationManager.notify(0, noti)

        }
    }
}
