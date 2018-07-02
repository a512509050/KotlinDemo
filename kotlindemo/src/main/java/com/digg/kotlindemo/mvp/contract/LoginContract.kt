package com.digg.kotlindemo.mvp.contract

import com.digg.kotlindemo.mvp.model.entity.LoginBean
import com.digg.kotlindemo.mvp.model.entity.RegisterBean
import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import io.reactivex.Observable

/**
 * <pre>
 * @author : Lvyan
 * Description : LoginContract
 * Date : 2018-6-27 15:58:30
 * </pre>
 */
interface LoginContract {
    /**
     *对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
     */
    interface View : IView

    /**
     * Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
     */
    interface Model : IModel {
        fun register(
                username: String,
                password: String,
                email: String
        ): Observable<RegisterBean>

        fun login(
                username: String,
                password: String
        ): Observable<LoginBean>
    }

}
