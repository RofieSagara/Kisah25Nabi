package com.tamvan.kisah25nabi.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.tamvan.kisah25nabi.R;
import com.tamvan.kisah25nabi.holder.Story;

public class ContensActivitry extends AppCompatActivity {

    static TextView textViewTitle;
    static WebView webViewContents;
    static AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contens_activitry);

        textViewTitle = (TextView)findViewById(R.id.textViewTitleContents);
        webViewContents = (WebView)findViewById(R.id.webViewContents);

        Story data = (Story)getIntent().getSerializableExtra("data");

        textViewTitle.setText(data.get_title());
        webViewContents.loadUrl("file:///android_asset/story/"+data.get_title()+".html");

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7437767659901172~4552756448");
        adView = (AdView)findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
