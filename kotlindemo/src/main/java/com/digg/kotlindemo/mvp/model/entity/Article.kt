package com.digg.kotlindemo.mvp.model.entity

/**
 * <pre>
 * @author : Lvyan
 * Description :
 * Date : 2018/7/2 14:25
</pre> *
 */
data class Article(val _id: String,
                   val createdAt: String,
                   val desc: String,
                   val publishedAt: String,
                   val source: String,
                   val type: String,
                   val url: String,
                   val isUsed: Boolean,
                   val who: String) {

    /**
     * _id : 5b399243421aa95570db5492
     * createdAt : 2018-07-02T10:47:31.359Z
     * desc : Android下载库，支持断点续传，保存下载进度，UI回调与生命周期绑定等。
     * publishedAt : 2018-07-02T00:00:00.0Z
     * source : chrome
     * type : Android
     * url : https://github.com/yuwenque/JarvisDownloader
     * used : true
     * who : lijinshanmx
     */

}
