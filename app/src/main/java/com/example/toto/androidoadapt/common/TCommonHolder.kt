package com.example.toto.androidoadapt.main.common

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View

/**
 * Created by toto on 2018/5/18.
 *
 */

open class TCommonHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    fun <T : View> findView(viewId: Int): T {
        return itemView.findViewTemp(viewId)
    }

    fun <T : View> View.findViewTemp(viewId: Int): T {
        val viewHolder: SparseArray<View> = tag as? SparseArray<View> ?: SparseArray()
        tag = viewHolder
        var childView: View? = viewHolder.get(viewId)
        if (null == childView) {
            childView = findViewById(viewId)
            viewHolder.put(viewId, childView)
        }
        return childView as T
    }

}