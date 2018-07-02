package com.digg.kotlindemo.mvp.presenter

import android.app.Application
import com.digg.kotlindemo.mvp.contract.RecommendContract
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

/**
 * <pre>
 * @author : Lvyan
 * Description : RecommendPresenter
 * Date : 2018-7-2 15:20:43
 * </pre>
 */
@FragmentScope
class RecommendPresenter
@Inject
constructor(model: RecommendContract.Model, rootView: RecommendContract.View) :
        BasePresenter<RecommendContract.Model, RecommendContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager


    override fun onDestroy() {
        super.onDestroy();
    }
}
