package com.michinari_nukazawa.lina_dicto_for_android

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private val webView by lazy { findViewById<WebView>(R.id.webView1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            webView.setBackgroundColor(Color.TRANSPARENT)
            webView.loadUrl("file:///android_asset/lina_dicto/index.html")
        } else {
            webView.restoreState(savedInstanceState)
        }

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.settings.allowFileAccessFromFileURLs = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        webView.restoreState(savedInstanceState)
    }
}
