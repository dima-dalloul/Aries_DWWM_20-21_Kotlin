package com.aries.phrasescultes

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*

        // Appel à Webview depuis Layout XML
        setContentView(R.layout.webview_exemple)

        val webview = findViewById<WebView>(R.id.webview)
        webview.loadUrl("https://www.android.com")
        */

        // Appel à Webview depuis Kotllin
        val maWebview : WebView = WebView(this)
        setContentView(maWebview)

        maWebview.loadUrl("https://www.android.com")
    }
}