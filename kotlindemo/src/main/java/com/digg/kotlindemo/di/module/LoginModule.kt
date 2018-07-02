package com.digg.kotlindemo.di.module

import com.digg.kotlindemo.mvp.contract.LoginContract
import com.digg.kotlindemo.mvp.model.LoginModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * <pre>
 * @author : Lvyan
 * Description : LoginModule
 * Date : 2018-6-27 15:58:31
 * </pre>
 */
@Module
//构建LoginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class LoginModule(private val view: LoginContract.View) {
    @ActivityScope
    @Provides
    fun provideLoginView(): LoginContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideLoginModel(model: LoginModel): LoginContract.Model {
        return model
    }
}
