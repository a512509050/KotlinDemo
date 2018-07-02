package com.digg.kotlindemo.mvp.presenter

import android.app.Application
import com.digg.kotlindemo.mvp.contract.HistoryContract
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

/**
 * <pre>
 * @author : Lvyan
 * Description : HistoryPresenter
 * Date : 2018-7-2 15:22:37
 * </pre>
 */
@FragmentScope
class HistoryPresenter
@Inject
constructor(model: HistoryContract.Model, rootView: HistoryContract.View) :
        BasePresenter<HistoryContract.Model, HistoryContract.View>(model, rootView) {
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
