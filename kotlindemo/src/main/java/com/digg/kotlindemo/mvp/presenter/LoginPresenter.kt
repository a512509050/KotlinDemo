package com.digg.kotlindemo.mvp.presenter

import android.app.Application
import android.util.Log
import com.digg.kotlindemo.app.utils.RxUtils
import com.digg.kotlindemo.mvp.contract.LoginContract
import com.digg.kotlindemo.mvp.model.entity.LoginBean
import com.digg.kotlindemo.mvp.model.entity.RegisterBean
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * <pre>
 * @author : Lvyan
 * Description : LoginPresenter
 * Date : 2018-6-27 15:58:30
 * </pre>
 */
@ActivityScope
class LoginPresenter
@Inject
constructor(model: LoginContract.Model, rootView: LoginContract.View) :
        BasePresenter<LoginContract.Model, LoginContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun login(username: String,
              password: String) {
        mModel.login(username, password)
                .compose(RxUtils.applySchedulers<LoginBean>(mRootView))
                .subscribe(object : ErrorHandleSubscriber<LoginBean>(mErrorHandler) {
                    override fun onNext(t: LoginBean) {
                        Log.d("a", t.toString())
                    }
                })
    }

    fun register(username: String,
                 password: String,
                 email: String) {
        mModel.register(username, password, email)
                .compose(RxUtils.applySchedulers<RegisterBean>(mRootView))
                .subscribe(object : ErrorHandleSubscriber<RegisterBean>(mErrorHandler) {
                    override fun onNext(t: RegisterBean) {
                        Log.d("a", t.toString())
                    }
                })
    }

}
