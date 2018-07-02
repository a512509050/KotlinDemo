package com.digg.kotlindemo.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import com.digg.kotlindemo.R
import com.digg.kotlindemo.di.component.DaggerLoginComponent
import com.digg.kotlindemo.di.module.LoginModule
import com.digg.kotlindemo.mvp.contract.LoginContract
import com.digg.kotlindemo.mvp.presenter.LoginPresenter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils


/**
 * 如果没presenter
 * 你可以这样写
 * <pre>
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 *     override fun onStart() {
 *     }
 *
 *     override fun onDestroy() {
 *     }
 * }
 * </pre>
 */

/**
 * <pre>
 * @author : Lvyan
 * Description : LoginActivity
 * Date : 2018-6-27 15:58:30
 * </pre>
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {

    @BindView(R.id.account)
    lateinit var mEtAccount: EditText
    @BindView(R.id.password)
    lateinit var mEtPassword: EditText
    @BindView(R.id.email)
    lateinit var mEtEmail: EditText

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(LoginModule(this))
                .build()
                .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_login //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    @OnClick(R.id.register, R.id.login)
    fun onClick(view: View) {
        val account = mEtAccount.text.trim().toString()
        val password = mEtPassword.text.trim().toString()
        val email = mEtEmail.text.trim().toString()
        when (view.id) {
            R.id.register -> {
                mPresenter?.register(account, password, email)
            }
            else -> {
                mPresenter?.login(account, password)
            }
        }
    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
