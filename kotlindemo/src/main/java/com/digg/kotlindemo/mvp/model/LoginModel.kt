package com.digg.kotlindemo.mvp.model

import android.app.Application
import com.digg.kotlindemo.mvp.contract.LoginContract
import com.digg.kotlindemo.mvp.model.api.Api
import com.digg.kotlindemo.mvp.model.api.service.CommonService
import com.digg.kotlindemo.mvp.model.entity.LoginBean
import com.digg.kotlindemo.mvp.model.entity.RegisterBean
import com.google.gson.Gson
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * <pre>
 * @author : Lvyan
 * Description : LoginModel
 * Date : 2018-6-27 15:58:31
 * </pre>
 */
@ActivityScope
class LoginModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), LoginContract.Model {
    override fun register(username: String, password: String, email: String): Observable<RegisterBean> {
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java)
                .register(Api.APP_KEY, username, password, email)
    }

    override fun login(username: String, password: String): Observable<LoginBean> {
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java)
                .login(Api.APP_KEY, username, password)
    }

    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application

}
