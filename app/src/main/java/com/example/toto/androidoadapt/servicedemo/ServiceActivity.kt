package com.example.toto.androidoadapt.servicedemo

import android.app.Activity
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Build
import android.os.Bundle
import com.example.toto.androidoadapt.R
import com.example.toto.androidoadapt.servicedemo.jobservice.JobDemoService
import kotlinx.android.synthetic.main.act_service.*

/**
 * Created by toto on 2018/7/4.
 *
 */
class ServiceActivity : Activity() {

    companion object {
        const val JOB_ID = 0x01
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_service)

    }


    override fun onResume() {
        super.onResume()
        send_a_job.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val JobScheduler = getSystemService(JobScheduler::class.java)
                val builder = JobInfo.Builder(JOB_ID, ComponentName("com.example.toto.androidoadapt", JobDemoService::class.java.name))
                builder.setBackoffCriteria(2000, JobInfo.BACKOFF_POLICY_LINEAR)
                //失败后的重试机制，一个线性的时间增长，一个指数级的时间增长。默认时间是30秒，android8后最小10秒
                builder.setMinimumLatency(1)

                val jobinfo = builder.build()
                JobScheduler.schedule(jobinfo)
            }
        }
    }

}