package com.paulino.haroldo.haroldportfolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class DetailActivity extends Activity {
    private Utilities utilities;

    private class DetailClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView backTextView = (TextView) findViewById(R.id.backTextView);

        backTextView.setOnClickListener(new DetailClickHandler());

        Activity activity = this;
        String action = getIntent().getExtras().getString("topic");
        utilities = new Utilities(activity);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setBackgroundColor(0x00000000);

        Calendar now = Calendar.getInstance();
        int myYearsOfExperienceProgramming = now.get(Calendar.YEAR) - 1996;
        String fileContents = utilities.getFileContentFromAssets(action + ".html");//.replace("MY_YEARS_OF_EXPERIENCE_PROGRAMMING",);
        webView.loadDataWithBaseURL("file:///android_asset/", fileContents, "text/html", "utf-8", null);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calling Haroldo Paulino", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                utilities.callPhone("8015025237");
            }
        });

        setTitle(utilities.getData("TITLE", action));
    }

}
