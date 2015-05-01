package com.health.yaopintong;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends ActionBarActivity {

    private ImageView welcome_iv;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(WelcomeActivity.this, MainTabActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome_iv = ((ImageView) findViewById(R.id.welcome_iv));
        Animation animation = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.anim_alpha);
        welcome_iv.startAnimation(animation);

        handler.sendEmptyMessageDelayed(1,2000);
    }


}
