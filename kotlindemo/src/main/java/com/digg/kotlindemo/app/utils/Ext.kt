package com.digg.kotlindemo.app.utils

import android.widget.ImageView
import com.blankj.utilcode.util.TimeUtils
import com.digg.kotlindemo.R
import com.jess.arms.http.imageloader.ImageConfig
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * <pre>
 * @author : Lvyan
 * Description :
 * Date : 2018/7/3 15:02
 * </pre>
 */
fun utcToShortDate(utcDate: String?): String {
    val replacedDate = utcDate?.replace("Z", " UTC")
    val utcFormattedDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z", Locale.getDefault())
    val defaultDate = utcFormattedDate.parse(replacedDate).time
    return TimeUtils.millis2String(defaultDate, SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()))
}

fun <T : ImageConfig> ImageView.loadImage(config: T) {
    ArmsUtils.obtainAppComponentFromContext(this.context)
            .imageLoader()
            .loadImage(this.context, config)
}

fun ImageView.loadImage(url: String) {
    loadImage(url, R.mipmap.ic_launcher)
}

fun ImageView.loadImage(url: String, placeholder: Int) {
    ArmsUtils.obtainAppComponentFromContext(this.context)
            .imageLoader().loadImage(this.context, ImageConfigImpl.builder()
                    .url(url)
                    .isCenterCrop(false)
                    .placeholder(placeholder)
                    .imageView(this)
                    .build())
}