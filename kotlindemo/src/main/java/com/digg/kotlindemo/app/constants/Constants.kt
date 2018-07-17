package com.digg.kotlindemo.app.constants

/**
 * <pre>
 * @author : Lvyan
 * Description : App的全局常量值
 * Date : 2017/11/6 17:13
</pre> *
 */
interface Constants {
    companion object {
        /**
         * tab切换fragment
         */
        const val FRAGMENT_REPLACE = "activity_fragment_replace"

        /**
         * List请求数量
         */
        const val PAGE_SIZE = 10

        /**
         * 通用界面跳转type
         */
        const val INTENT_COMMON_KEY = "INTENT_COMMON_KEY"
    }
}