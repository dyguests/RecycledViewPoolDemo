package com.fanhl.recycledviewpooldemo

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity

class MainAdapter : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>(null) {
    init {
        addItemType(ITEM_TYPE_QUESTION_VIDEO_VOTING, R.layout.item_main)
    }

    override fun convert(helper: BaseViewHolder?, item: MultiItemEntity?) {

    }

    companion object {
        const val ITEM_TYPE_QUESTION_VIDEO_VOTING = 1
    }

    /**
     * @param type 当前itemView的类型
     */
    class MainItem(
        val type: Int,
        val data: Post
    ) : MultiItemEntity {

        override fun getItemType(): Int {
            return type
        }
    }
}
