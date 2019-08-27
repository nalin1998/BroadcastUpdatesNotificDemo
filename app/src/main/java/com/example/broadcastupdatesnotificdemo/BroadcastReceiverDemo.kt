package com.example.broadcastupdatesnotificdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

const val Channel_ID = "random_ID"
const val Channel_Name = "random_Name"
const val Channel_Importance = NotificationManager.IMPORTANCE_DEFAULT

class BroadcastReceiverDemo : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent !=null && "MyAction".equals(intent.action)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //creating notification Manager


                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


                //declaring notification channel
                val notificationChannel = NotificationChannel(Channel_ID, Channel_Name, Channel_Importance)

                //creating notification channel
                notificationManager.createNotificationChannel(notificationChannel)


                //building a notification
                val notificationBuilder = NotificationCompat.Builder(context, Channel_ID)
                    .setOngoing(true)//sticky notification
                    .setContentTitle("Sticky Notification")
                    .setSmallIcon(R.mipmap.ic_launcher)

                for (i in 1..10) {
                    notificationBuilder.setContentText("Progress ${10*i} %")
                    notificationBuilder.setProgress(100, 10 * i, false)
                    notificationManager.notify(1, notificationBuilder.build())
                    Thread.sleep(1000)
                }
                notificationBuilder.setOngoing(false)
                notificationManager.notify(1, notificationBuilder.build())


            }


        }
    }

}