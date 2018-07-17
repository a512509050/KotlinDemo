package com.digg.kotlindemo.mvp.presenter

import android.app.Application
import com.digg.kotlindemo.app.constants.Constants
import com.digg.kotlindemo.app.utils.RxUtils
import com.digg.kotlindemo.mvp.contract.GirlsContract
import com.digg.kotlindemo.mvp.model.entity.Article
import com.digg.kotlindemo.mvp.ui.adapter.GirlsAdapter
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
 * Description : GirlsPresenter
 * Date : 2018-7-2 15:22:15
 * </pre>
 */
@FragmentScope
class GirlsPresenter
@Inject
constructor(model: GirlsContract.Model, rootView: GirlsContract.View) :
        BasePresenter<GirlsContract.Model, GirlsContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager
    @Inject
    lateinit var mAdapter: GirlsAdapter

    fun getData(pageNo: Int, isRefresh: Boolean) {

        mModel.getData(pageNo)
                .compose(RxUtils.applySchedulers(mRootView))
                .subscribe(object : ErrorHandleSubscriber<List<Article>>(mErrorHandler) {

                    override fun onNext(t: List<Article>) {
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
