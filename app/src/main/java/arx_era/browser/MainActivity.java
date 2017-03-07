package arx_era.browser;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView loadURL;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadURL = (WebView) findViewById(R.id.loadURL);
        loadURL.getSettings().setJavaScriptEnabled(true);
        loadURL.loadUrl("http://www.google.com");
        loadURL.setWebViewClient(new LoadURL());

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
    }

    private class LoadURL extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            toolbar.setTitle(view.getTitle());
        }
    }
}
