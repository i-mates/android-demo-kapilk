package in.imates.sidedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by root on 6/10/15.
 */
public class Menu1_Fragment  extends Fragment{

    WebView web1;
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.menu1_layout,container,false);
      web1 = (WebView) rootview.findViewById(R.id.web1);
        web1.getSettings().setJavaScriptEnabled(true);
        web1.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        web1.getSettings().setBuiltInZoomControls(true);
        web1.getSettings().setSupportZoom(true);
        web1.setWebViewClient(new WebViewClient());
        web1.loadUrl("http://www.i-mates.in/");

        return rootview;
    }
}
