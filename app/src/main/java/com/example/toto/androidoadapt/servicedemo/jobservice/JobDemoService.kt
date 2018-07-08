package com.example.toto.androidoadapt.servicedemo.jobservice

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

/**
 * Created by toto on 2018/7/7.
 *
 */
class JobDemoService:JobService(){

    override fun onCreate() {
        Log.d("tianhao", String.format("onCreate: "))
        super.onCreate()
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("tianhao", String.format("onStartJob: "))
        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("tianhao", String.format("onStopJob: "))
        return false
    }
}