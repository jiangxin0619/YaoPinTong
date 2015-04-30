package com.health.yaopintong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.slidingmenu.lib.SlidingMenu;

/**
 * 主界面
 *
 */
public class MainActivity extends FragmentActivity {
    private RadioGroup rg;
    private ListView search_lv;
    private ImageView left,right;

    private int[] rbIds={R.id.search_btn1,R.id.search_btn2,R.id.search_btn3};
    private View[] views=new View[3];

    public MainActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SlidingMenu menu = new SlidingMenu(this);
        search_lv= ((ListView) findViewById(R.id.search_lv));

        left= ((ImageView) findViewById(R.id.top_left_img));

        //头部右按钮
        right= ((ImageView) findViewById(R.id.top_right_img));
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //对症下药那些RadioButton
        rg= ((RadioGroup) findViewById(R.id.search_rg));
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i=0;i<rbIds.length;i++){
                    if(rbIds[i]==checkedId){
                        views[i].setVisibility(View.VISIBLE);
                    }else{
                        views[i].setVisibility(View.INVISIBLE);
                    }
                }

            }
        });
        init();
    }
    private void init() {
        views[0]=findViewById(R.id.search_view1);
        views[1]=findViewById(R.id.search_view2);
        views[2]=findViewById(R.id.search_view3);
    }


}
