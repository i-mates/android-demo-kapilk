package in.imates.tabapp;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class TabMain extends ActionBarActivity  {

    TabHost th;
    WebView w1,w2,w3,w4,w5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

         th = (TabHost) findViewById(R.id.tabHost);
        th.setScrollBarStyle(View.SCROLL_AXIS_HORIZONTAL);
        th.setup();
        TabSpec sp = th.newTabSpec("tag1");
        sp.setContent(R.id.tab1);
        sp.setIndicator("Main Page");
        w1 = (WebView) findViewById(R.id.webtab1);
        w1.getSettings().setJavaScriptEnabled(true);
        w1.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        w1.getSettings().setBuiltInZoomControls(true);
        w1.getSettings().setSupportZoom(true);
        w1.setWebViewClient(new WebViewClient());
        w1.loadUrl("http://www.i-mates.in/");
        th.addTab(sp);
        sp = th.newTabSpec("tag2");
        sp.setContent(R.id.tab2);
        sp.setIndicator("About");
        w2 = (WebView) findViewById(R.id.webtab2);
        w2.getSettings().setJavaScriptEnabled(true);
        w2.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        w2.getSettings().setBuiltInZoomControls(true);
        w2.getSettings().setSupportZoom(true);
        w2.setWebViewClient(new WebViewClient());
        w2.loadUrl("http://i-mates.in/about");
        th.addTab(sp);
        sp = th.newTabSpec("tag3");
        sp.setContent(R.id.tab3);
        sp.setIndicator("Services");
        w3 = (WebView) findViewById(R.id.webtab3);
        w3.getSettings().setJavaScriptEnabled(true);
        w3.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        w3.getSettings().setBuiltInZoomControls(true);
        w3.getSettings().setSupportZoom(true);
        w3.setWebViewClient(new WebViewClient());
        w3.loadUrl("http://i-mates.in/services");
        th.addTab(sp);
        sp = th.newTabSpec("tag4");
        sp.setContent(R.id.tab4);
        sp.setIndicator("Products");
        w4 = (WebView) findViewById(R.id.webtab4);
        w4.getSettings().setJavaScriptEnabled(true);
        w4.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        w4.getSettings().setBuiltInZoomControls(true);
        w4.getSettings().setSupportZoom(true);
        w4.setWebViewClient(new WebViewClient());
        w4.loadUrl("http://i-mates.in/products");
        th.addTab(sp);
        sp = th.newTabSpec("tag5");
        sp.setContent(R.id.tab5);
        sp.setIndicator("Careers");
        w5 = (WebView) findViewById(R.id.webtab5);
        w5.getSettings().setJavaScriptEnabled(true);
        w5.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        w5.getSettings().setBuiltInZoomControls(true);
        w5.getSettings().setSupportZoom(true);
        w5.setWebViewClient(new WebViewClient());
        w5.loadUrl("http://i-mates.in/careers");
        th.addTab(sp);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
