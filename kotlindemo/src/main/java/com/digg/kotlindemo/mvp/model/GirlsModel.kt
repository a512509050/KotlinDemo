package com.digg.kotlindemo.mvp.model

import android.app.Application
import com.digg.kotlindemo.app.constants.CategoryType
import com.digg.kotlindemo.app.constants.Constants
import com.digg.kotlindemo.mvp.contract.GirlsContract
import com.digg.kotlindemo.mvp.model.api.service.CommonService
import com.digg.kotlindemo.mvp.model.entity.Article
import com.google.gson.Gson
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * <pre>
 * @author : Lvyan
 * Description : GirlsModel
 * Date : 2018-7-2 15:22:15
 * </pre>
 */
@FragmentScope
class GirlsModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), GirlsContract.Model {
    override fun getData(pageNo: Int): Observable<List<Article>> {
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java)
                .getData(CategoryType.福利.name, Constants.PAGE_SIZE, pageNo)
                .map { it.results }
    }

    @Inject
    lateinit var mGson: Gson
    @Inject
    lateinit var mApplication: Application

}
