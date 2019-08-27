package com.example.broadcastupdatesnotificdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerClass(private val context : Context , workerParameters: WorkerParameters) : Worker(context , workerParameters){

    override fun doWork(): Result {
        val intent : Intent = Intent("MyAction")
        intent.setClass(context , BroadcastReceiverDemo::class.java)
        context.sendBroadcast(intent)
        return Result.success()
    }


}