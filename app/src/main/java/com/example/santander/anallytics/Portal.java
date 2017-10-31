package com.example.santander.anallytics;

        import android.app.Fragment;
        import android.content.Intent;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.graphics.Bitmap;
        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import com.example.santander.anallytics.R;

public class Portal extends Activity {

    //private EditText editText;
    private WebView webView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        // editText = (EditText) findViewById(R.id.url);
        webView = (WebView)   findViewById(R.id.webViewlayout);
        webView.setWebViewClient(new MyBrowser());

    }


    public void proximaTela(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void acessoGoogle (View V) {

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("http://www.portalcsa.sb");
    }


   /*@Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/


    public class MyBrowser extends WebViewClient {
        public boolean overrideUrlLoaging (WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

}
