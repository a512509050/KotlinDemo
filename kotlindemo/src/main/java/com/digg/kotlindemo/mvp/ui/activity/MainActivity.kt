package com.digg.kotlindemo.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.blankj.utilcode.util.FragmentUtils
import com.digg.kotlindemo.R
import com.digg.kotlindemo.app.constants.Constants
import com.digg.kotlindemo.di.component.DaggerMainComponent
import com.digg.kotlindemo.di.module.MainModule
import com.digg.kotlindemo.mvp.contract.MainContract
import com.digg.kotlindemo.mvp.presenter.MainPresenter
import com.digg.kotlindemo.mvp.ui.fragment.GirlsFragment
import com.digg.kotlindemo.mvp.ui.fragment.HistoryFragment
import com.digg.kotlindemo.mvp.ui.fragment.RecommendFragment
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */

/**
 * <pre>
 * @author : Lvyan
 * Description : MainActivity
 * Date : 2018-7-2 14:42:33
 * </pre>
 */
class MainActivity : BaseActivity<MainPresenter>(), MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener {

    private var mFragments: List<Fragment>? = null
    private var mPosition: Int = -1

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mPosition = item.order
        selectTab(mPosition)
        return true
    }

    private fun selectTab(mPosition: Int) {
        FragmentUtils.showHide(mPosition, mFragments!!)
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    override fun initData(savedInstanceState: Bundle?) {
        mNavTab.setOnNavigationItemSelectedListener(this)
        initFragments(savedInstanceState)
    }

    private fun initFragments(savedInstanceState: Bundle?) {
        val recommendFragment: RecommendFragment
        val girlsFragment: GirlsFragment
        val historyFragment: HistoryFragment
        val fm = supportFragmentManager

        if (savedInstanceState == null) {
            recommendFragment = RecommendFragment.newInstance()
            girlsFragment = GirlsFragment.newInstance()
            historyFragment = HistoryFragment.newInstance()
        } else {
            savedInstanceState.getInt(Constants.FRAGMENT_REPLACE)
            recommendFragment = FragmentUtils.findFragment(fm, RecommendFragment::class.java) as RecommendFragment
            girlsFragment = FragmentUtils.findFragment(fm, GirlsFragment::class.java) as GirlsFragment
            historyFragment = FragmentUtils.findFragment(fm, HistoryFragment::class.java) as HistoryFragment
        }

        if (mFragments == null) {
            mFragments = mutableListOf()
            (mFragments as MutableList<Fragment>).add(recommendFragment)
            (mFragments as MutableList<Fragment>).add(girlsFragment)
            (mFragments as MutableList<Fragment>).add(historyFragment)
        }

        FragmentUtils.add(fm, mFragments!!, R.id.fl_main, if (mPosition > 0) mPosition else 0)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

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
