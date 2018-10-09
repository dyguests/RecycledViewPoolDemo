package com.fanhl.recycledviewpooldemo

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter : BaseQuickAdapter<Post, MainAdapter.ViewHolder>(R.layout.item_main) {

    override fun convert(helper: MainAdapter.ViewHolder?, item: Post?) {
        helper?.bind(item ?: return)
    }

    class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
        init {

        }

        fun bind(post: Post) {
            itemView.container.apply {
                post {
                    var videoView = findViewById(R.id.video) ?: View.inflate(context, R.layout.partial_item_video, null).also {
                        it.id = R.id.video
                        addView(it)
                    }
                    var imageView = findViewById(R.id.image) ?: View.inflate(context, R.layout.partial_item_image, null).also {
                        it.id = R.id.image
                        addView(it)
                    }
                    var imagesView = findViewById(R.id.images) ?: View.inflate(context, R.layout.partial_item_images, null).also {
                        it.id = R.id.images
                        addView(it)
                    }
                }
            }
        }
    }
}
