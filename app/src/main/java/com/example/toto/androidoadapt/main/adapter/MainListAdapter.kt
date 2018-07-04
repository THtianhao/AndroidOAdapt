package com.example.toto.androidoadapt.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.toto.androidoadapt.R
import com.example.toto.androidoadapt.main.common.TCommonHolder

/**
 * Created by toto on 2018/7/4.
 *
 */
class MainListAdapter(var context: Context, var list: List<String>) : RecyclerView.Adapter<MainListAdapter.MainListHolder>() {
    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        holder.onBindViewHolder(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list_adapter, parent, false)
        return MainListHolder(view)
    }

    override fun getItemCount(): Int = list.size

    class MainListHolder(itemView: View) : TCommonHolder(itemView), View.OnClickListener {
        var mTextView: TextView = findView(R.id.main_list_text);
        fun onBindViewHolder(s: String) {
            mTextView.setText(s)
        }

        override fun onClick(p0: View?) {
            when (p0?.id) {
                R.id.main_list_text -> {

                }
            }
        }


    }
}