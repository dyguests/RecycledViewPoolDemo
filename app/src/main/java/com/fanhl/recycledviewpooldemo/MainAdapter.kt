package com.fanhl.recycledviewpooldemo

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class MainAdapter : BaseQuickAdapter<Post, MainAdapter.ViewHolder>(R.layout.item_main) {

    override fun convert(helper: MainAdapter.ViewHolder?, item: Post?) {

    }

    class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
        init {

        }
    }
}
