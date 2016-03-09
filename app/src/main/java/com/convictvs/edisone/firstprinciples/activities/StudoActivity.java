package com.convictvs.edisone.firstprinciples.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.convictvs.edisone.firstprinciples.R;
import com.convictvs.edisone.firstprinciples.fragments.ScriptureFragment;

public class StudoActivity extends AppCompatActivity {

    public static final String ARG_URL_SCRITURE = "com.convictvs.edisone.firstprinciples.URL_SCRIPTURE";

    private WebView webview_estudo;
    private Toolbar tool_bar_estudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studo);

        Intent intent = getIntent();
        String file_estudo = intent.getStringExtra(MainActivity.POSITION_ESTUDO);
        String title_estudo = intent.getStringExtra(MainActivity.TITLE_ESTUDO);

        tool_bar_estudo = (Toolbar) findViewById(R.id.tool_bar_estudo);
        setSupportActionBar(tool_bar_estudo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title_estudo);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_home);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        webview_estudo = (WebView) findViewById(R.id.webView_estudo);
        webview_estudo.loadUrl(file_estudo);

        webview_estudo.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView  view, String  url){
                //Toast.makeText(view.getContext(), "", Toast.LENGTH_SHORT).show();
                if(url.charAt(0) == 'f'){
                    FragmentManager fm = getSupportFragmentManager();
                    ScriptureFragment scriptureFragment = new ScriptureFragment();
                    Bundle args = new Bundle();
                    args.putString(ARG_URL_SCRITURE, url);
                    scriptureFragment.setArguments(args);
                    scriptureFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.dialog);
                    scriptureFragment.show(fm, "Escritura");
                }
                else{
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
            /*case R.id.action_home:
                return true;*/
            /*case R.id.action_settings:
                return  true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
