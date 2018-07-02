package com.digg.kotlindemo.mvp.contract

import com.jess.arms.mvp.IView
import com.jess.arms.mvp.IModel

/**
 * <pre>
 * @author : Lvyan
 * Description : MainContract
 * Date : 2018-7-2 14:42:33
 * </pre>
 */
interface MainContract {
    /**
     *对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
     */
    interface View : IView

    /**
     * Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
     */
    interface Model : IModel

}
