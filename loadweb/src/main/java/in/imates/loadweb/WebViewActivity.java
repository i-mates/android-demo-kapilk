package in.imates.loadweb;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ScaleGestureDetector;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by root on 30/9/15.
 */
public class WebViewActivity extends Activity {

    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView) findViewById(R.id.webView12);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.i-mates.in/");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;

        }

        return super.onKeyDown(keyCode, event);

    }
}
