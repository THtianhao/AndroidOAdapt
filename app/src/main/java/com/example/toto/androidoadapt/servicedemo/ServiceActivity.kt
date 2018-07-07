package com.example.toto.androidoadapt.servicedemo

import android.app.Activity
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import com.example.toto.androidoadapt.servicedemo.jobservice.JobDemoService

/**
 * Created by toto on 2018/7/4.
 */
class ServiceActivity : Activity() {

    companion object {
        const val JOB_ID = 0x01
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var JobScheduler = getSystemService(JobScheduler::class.java)
            val builder = JobInfo.Builder(JOB_ID, ComponentName("com.example.toto.androidoadapt.servicedemo.jobservice", JobDemoService::class.java.name))
            builder.setBackoffCriteria(2000, JobInfo.BACKOFF_POLICY_LINEAR);
            //失败后的重试机制，一个线性的时间增长，一个指数级的时间增长。

        }
    }

}