package com.iitm.vishruit.iitmfirewallautoauthenticationkeepalive;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    String url = "https://nfw.iitm.ac.in:1003/login?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et_roll = (EditText)findViewById(R.id.et_roll);
        final EditText et_password = (EditText)findViewById(R.id.et_password);
        Button bt_submit = (Button)findViewById(R.id.bt_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( et_roll.getText().toString().equals("") || et_password.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "Please check your roll number and password.", Toast.LENGTH_SHORT).show();
                else {
                    setContentView(R.layout.activity_main);
                    TextView tv_hello = (TextView)findViewById(R.id.tv_hello);
                    tv_hello.setText(et_roll.getText().append(et_password.getText()));
                    mainActivityEnv();
                }
            }
        });
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
            // Ignore SSL certificate errors
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setContentView(R.layout.activity_login);
    }

    private void mainActivityEnv() {
        WebView myWebView = (WebView) findViewById(R.id.webView);

        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.setWebViewClient(new MyBrowser());
        myWebView.loadUrl(url);
    }


}