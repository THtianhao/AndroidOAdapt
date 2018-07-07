package com.example.toto.androidoadapt.common

import android.support.v7.widget.RecyclerView

/**
 * Created by toto on 2018/7/4.
 */
interface TRecyclerClickListener {

    fun onItemClick(holer: RecyclerView.ViewHolder, position: Int)
}