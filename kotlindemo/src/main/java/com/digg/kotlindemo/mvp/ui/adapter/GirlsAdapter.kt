package com.digg.kotlindemo.mvp.ui.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.digg.kotlindemo.R
import com.digg.kotlindemo.app.utils.loadImage
import com.digg.kotlindemo.mvp.model.entity.Article
import com.jess.arms.http.imageloader.glide.ImageConfigImpl

/**
 * <pre>
 * @author : Lvyan
 * Description :
 * Date : 2018/7/4 15:46
 * </pre>
 */
class GirlsAdapter(data: List<Article>) : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_girl, data) {
    override fun convert(helper: BaseViewHolder?, item: Article?) {
        val imageView = helper?.getView<ImageView>(R.id.imageView)
        item?.url?.let {
            imageView?.loadImage(ImageConfigImpl.builder()
                    .url(it)
                    .isCenterCrop(false)
                    .imageView(imageView)
                    .build())
        }
        imageView?.let { Glide.with(mContext).load(item?.url).into(it) }
    }
}