package com.health.yaopintong;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TabHost;


public class MainTabActivity extends TabActivity {

    private RadioGroup maintab_rg_bottom;
    private TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_tab);

        //实例化TabHost
        tabhost = getTabHost();
        //添加选项卡
        tabhost.addTab(tabhost.newTabSpec("ONE").setIndicator("ONE").setContent(new Intent(this,SearchActivity.class)));
        tabhost.addTab(tabhost.newTabSpec("TWO").setIndicator("TWO").setContent(new Intent(this,ScanActivity.class)));
        tabhost.addTab(tabhost.newTabSpec("THREE").setIndicator("THREE").setContent(new Intent(this,NearActivity.class)));
        tabhost.addTab(tabhost.newTabSpec("FOUR").setIndicator("FOUR").setContent(new Intent(this,AlarmActivity.class)));

        maintab_rg_bottom = ((RadioGroup) findViewById(R.id.maintab_rg_bottom));
        maintab_rg_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.maintab_rb_search:
                        tabhost.setCurrentTabByTag("ONE");
                        break;
                    case R.id.maintab_rb_scan:
                        tabhost.setCurrentTabByTag("TWO");
                        break;
                    case R.id.maintab_rb_near:
                        tabhost.setCurrentTabByTag("THREE");
                        break;
                    case R.id.maintab_rb_alarm:
                        tabhost.setCurrentTabByTag("FOUR");
                        break;
                }
            }
        });
    }

}
