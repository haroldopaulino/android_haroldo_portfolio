package com.paulino.haroldo.haroldportfolio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    private CountDownTimer timer;
    int swipeProgress = 0;
    Utilities utilities;
    SeekBar swipeSeekbar;
    TextView addressTextView,
            phoneNumberTextView,
            emailTextView;

    class buttonOnClickListener implements View.OnClickListener {
        String action;
        buttonOnClickListener (String inputAction) {
            action = inputAction;
        }

        @Override
        public void onClick(View v) {
            switch(action) {
                case "CALL" : utilities.callPhone("18015025237"); break;
                case "MAP" : utilities.openMap(); break;
                case "EMAIL" : utilities.sendEmail(); break;
            }
        }
    }

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };

    private final View.OnTouchListener mDelayHideTouchListener = (view, motionEvent) -> {
        if (AUTO_HIDE) {
            //delayedHide(AUTO_HIDE_DELAY_MILLIS);
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        utilities = new Utilities(this);
        swipeSeekbar = (SeekBar) findViewById(R.id.swipeSeekbar);
        addressTextView = (TextView) findViewById(R.id.addressTextView);
        phoneNumberTextView = (TextView) findViewById(R.id.phoneNumberTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);

        addressTextView.setText(Html.fromHtml("<u>559 E 2200 S<br/>Clearfield, Utah 84015</u>"));
        phoneNumberTextView.setText(Html.fromHtml("<u>(801) 502-5237</u>"));
        emailTextView.setText(Html.fromHtml("<u>haroldopaulino@hotmail.com</u>"));

        addressTextView.setOnClickListener(new buttonOnClickListener("MAP"));
        phoneNumberTextView.setOnClickListener(new buttonOnClickListener("CALL"));
        emailTextView.setOnClickListener(new buttonOnClickListener("EMAIL"));

        swipeSeekbar.setProgress(10);
        swipeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                swipeProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (swipeProgress > 65) {
                    launchResume();
                } else {
                    timer = new CountDownTimer(1000, 15) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            swipeSeekbar.setProgress(swipeSeekbar.getProgress() - 1);
                            if (swipeSeekbar.getProgress() == 10) {
                                timer.cancel();
                            }
                        }

                        @Override
                        public void onFinish() {
                            try{
                                swipeSeekbar.setProgress(10);
                                timer.cancel();
                            } catch(Exception ignored) {
                            }
                        }
                    }.start();
                }
            }
        });
    }

    protected void launchResume() {
        Intent intent = new Intent(this, PortfolioResumeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        swipeSeekbar.setProgress(10);
    }
}
