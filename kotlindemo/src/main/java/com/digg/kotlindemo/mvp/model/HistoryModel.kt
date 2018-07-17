package com.digg.kotlindemo.mvp.model

import android.app.Application
import com.digg.kotlindemo.app.constants.Constants
import com.digg.kotlindemo.mvp.contract.HistoryContract
import com.digg.kotlindemo.mvp.model.api.service.CommonService
import com.digg.kotlindemo.mvp.model.entity.History
import com.google.gson.Gson
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * <pre>
 * @author : Lvyan
 * Description : HistoryModel
 * Date : 2018-7-2 15:22:37
 * </pre>
 */
@FragmentScope
class HistoryModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), HistoryContract.Model {
    override fun getHistory(pageNo: Int): Observable<List<History>> {
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java)
                .getHistoryList(Constants.PAGE_SIZE, pageNo)
                .map { t -> t.results }
    }

    @Inject
    lateinit var mGson: Gson
    @Inject
    lateinit var mApplication: Application

}
