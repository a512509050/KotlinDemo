package com.digg.kotlindemo.mvp.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.digg.kotlindemo.R
import com.digg.kotlindemo.app.utils.utcToShortDate
import com.digg.kotlindemo.mvp.model.entity.History

/**
 * <pre>
 * @author : Lvyan
 * Description :
 * Date : 2018/7/3 10:34
 * </pre>
 */
class HistoryAdapter(data: List<History>) : BaseQuickAdapter<History, BaseViewHolder>(R.layout.item_history, data) {

    override fun convert(helper: BaseViewHolder?, item: History?) {
        helper?.setText(R.id.content, "${item?.title}(${utcToShortDate(item?.publishedAt)})")
    }

}