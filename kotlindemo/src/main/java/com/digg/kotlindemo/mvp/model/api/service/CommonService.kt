package com.digg.kotlindemo.mvp.model.api.service

import com.digg.kotlindemo.mvp.model.entity.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("data/{type}/{pageSize}/{pageNumber}")
    fun getData(
            @Path("type") type: String,
            @Path("pageSize") pageSize: Int,
            @Path("pageNumber") pageNumber: Int
    ): Observable<BaseBean<List<Article>>>

    @GET("history/content/{pageSize}/{pageNumber}")
    fun getHistoryList(
            @Path("pageSize") pageSize: Int,
            @Path("pageNumber") pageNumber: Int
    ): Observable<BaseBean<List<History>>>

}