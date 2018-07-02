package com.digg.kotlindemo.mvp.model.api

/**
 * ================================================
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 *
 *
 * Created by MVPArmsTemplate
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
interface Api {
    companion object {
        /**
         * mob app key
         */
        const val APP_KEY = "1be865c0e67e3"
        /**
         * mob api
         */
//        const val APP_DOMAIN = "http://apicloud.mob.com/"
        const val APP_DOMAIN = "http://gank.io/api/"
    }
}
