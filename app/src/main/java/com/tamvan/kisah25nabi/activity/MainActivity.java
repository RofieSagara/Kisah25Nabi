package com.tamvan.kisah25nabi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.tamvan.kisah25nabi.R;
import com.tamvan.kisah25nabi.customview.CustomViewListCerita;
import com.tamvan.kisah25nabi.holder.Story;
import com.tamvan.kisah25nabi.tools.InputOutput;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ListView listViewStory;
    static AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewStory = (ListView)findViewById(R.id.listViewStory);
        StartUp();
        listViewStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Story dataView = (Story) view.getTag();
                Intent intent = new Intent("com.tamvan.kisah25nabi.activity.ContensActivitry");
                intent.putExtra("data", dataView);
                startActivity(intent);
            }
        });

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7437767659901172~4552756448");
        adView = (AdView)findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void StartUp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputOutput inputOutput = new InputOutput();
                    List<Story> temp = inputOutput.ReadDataAllFromAsset(MainActivity.this);
                    final Story[] dataStory = temp.toArray(new Story[temp.size()]);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            final CustomViewListCerita customViewListCerita = new CustomViewListCerita(MainActivity.this, dataStory);
                            listViewStory.setAdapter(customViewListCerita);
                        }
                    });
                } catch (IOException e) {

                }

            }
        }).start();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
