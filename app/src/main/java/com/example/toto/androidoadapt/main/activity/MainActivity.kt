package com.example.toto.androidoadapt.main.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.toto.androidoadapt.R
import com.example.toto.androidoadapt.main.adapter.MainListAdapter
import com.example.toto.androidoadapt.notification.NotificationActivity
import com.example.toto.androidoadapt.receiver.ReceiverActivity
import com.example.toto.androidoadapt.servicedemo.ServiceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter: MainListAdapter
    lateinit var mMainList: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        closeContextMenu()
        initData()
    }

    private fun initData() {
        mMainList = listOf("Receiver", "Notification", "Service")
    }

    override fun onResume() {
        super.onResume()
        initView();
    }

    private fun initView() {
        mAdapter = MainListAdapter(this, mMainList, { _, i ->
            when (i) {
                0 -> startActivity(Intent(this, ServiceActivity::class.java))
                1 -> startActivity(Intent(this, NotificationActivity::class.java))
                2 -> startActivity(Intent(this, ReceiverActivity::class.java))
            }
        })
        main_list.layoutManager = LinearLayoutManager(this)
        main_list.adapter = mAdapter

    }

}
