package com.example.broadcastupdatesnotificdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(WorkerClass::class.java).build()

        WorkManager.getInstance(this).enqueue(workRequest)

    }

}
