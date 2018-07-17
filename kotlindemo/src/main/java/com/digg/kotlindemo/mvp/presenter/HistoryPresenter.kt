package com.digg.kotlindemo.mvp.presenter

import android.app.Application
import com.digg.kotlindemo.app.constants.Constants
import com.digg.kotlindemo.app.utils.RxUtils
import com.digg.kotlindemo.mvp.contract.HistoryContract
import com.digg.kotlindemo.mvp.model.entity.History
import com.digg.kotlindemo.mvp.ui.adapter.HistoryAdapter
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
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
    @Inject
    lateinit var mAdapter: HistoryAdapter

    fun getData(pageNo: Int, isRefresh: Boolean) {

        mModel.getHistory(pageNo)
                .compose(RxUtils.applySchedulers(mRootView))
                .subscribe(object : ErrorHandleSubscriber<List<History>>(mErrorHandler) {

                    override fun onNext(t: List<History>) {
                        if (isRefresh) {
                            mAdapter.setNewData(t)
                        } else {
                            if (t.isNotEmpty()) {
                                mAdapter.addData(t)
                            }
                        }

                        if (t.size < Constants.PAGE_SIZE) {
                            mAdapter.loadMoreEnd(isRefresh)
                        } else {
                            mAdapter.loadMoreComplete()
                        }

                        mRootView.hideLoading()
                    }

                })

    }
}
