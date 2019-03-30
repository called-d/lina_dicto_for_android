package com.michinari_nukazawa.lina_dicto_for_android

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private val webView by lazy { findViewById<WebView>(R.id.webView1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.apply {
            if (savedInstanceState == null) {
                setBackgroundColor(Color.TRANSPARENT)
                loadUrl("file:///android_asset/lina_dicto/index.html")
            } else {
                restoreState(savedInstanceState)
            }
        }

        with (webView.settings) {
            javaScriptEnabled = true
            allowFileAccessFromFileURLs = true
        }

        WebView.setWebContentsDebuggingEnabled(true)
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
