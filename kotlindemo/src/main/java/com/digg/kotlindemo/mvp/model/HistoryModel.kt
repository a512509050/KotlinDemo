package com.digg.kotlindemo.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

import com.digg.kotlindemo.mvp.contract.HistoryContract

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
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
