package com.digg.kotlindemo.mvp.model.api.service

import com.digg.kotlindemo.mvp.model.entity.Article
import com.digg.kotlindemo.mvp.model.entity.BaseBean
import com.digg.kotlindemo.mvp.model.entity.LoginBean
import com.digg.kotlindemo.mvp.model.entity.RegisterBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * <pre>
 * @author : Lvyan
 * Description :
 * Date : 2018/6/27 16:39
 * </pre>
 */
interface CommonService {

    @GET("user/rigister")
    fun register(
            @Query("key") key: String,
            @Query("username") username: String,
            @Query("password") password: String,
            @Query("email") email: String
    ): Observable<RegisterBean>

    @GET("user/login")
    fun login(
            @Query("key") key: String,
            @Query("username") username: String,
            @Query("password") password: String
    ): Observable<LoginBean>

    @GET("data")
    fun getData(
            @Query("type") type: String,
            @Query("pageSize") pageSize: String,
            @Query("pageNumber") pageNumber: String
    ): Observable<BaseBean<Article>>
}