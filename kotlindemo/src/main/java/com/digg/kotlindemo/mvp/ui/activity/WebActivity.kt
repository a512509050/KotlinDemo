package com.digg.kotlindemo.mvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.LinearLayout
import com.digg.kotlindemo.R
import com.digg.kotlindemo.app.constants.Constants
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.include_title.*


class WebActivity : AppCompatActivity() {

    private lateinit var mAgentWeb: AgentWeb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val url = intent.getStringExtra(Constants.INTENT_COMMON_KEY)

        val replace = url.replace("\n", "").replace("'\'", "")

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(container, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(object :WebChromeClient(){
                    override fun onReceivedTitle(view: WebView?, title: String?) {
                        super.onReceivedTitle(view, title)
                        toolbar_title.text = title
                    }
                })
                .createAgentWeb()
                .ready()
                .go(null)

        mAgentWeb.urlLoader.loadData(replace, "text/html", "UTF-8")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return mAgentWeb.handleKeyEvent(keyCode, event) || super.onKeyDown(keyCode, event)
    }

    override fun onPause() {
        mAgentWeb.webLifeCycle.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb.webLifeCycle.onDestroy()
        super.onDestroy()
    }

}
