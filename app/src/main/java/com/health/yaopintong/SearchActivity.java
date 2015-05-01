package com.health.yaopintong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.health.yaopintong.fragments.FragmentType;
import com.health.yaopintong.fragments.Fragment_Medicine;
import com.health.yaopintong.fragments.Fragment_Sort;
import com.health.yaopintong.helpers.BitmapHelper;
import com.health.yaopintong.myview.MyViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends FragmentActivity {
    private RadioGroup rg;
    private ImageView left, right;

    private int[] rbIds = {R.id.search_btn1, R.id.search_btn2, R.id.search_btn3};
    private View[] views = new View[3];
    private SlidingMenu slidingMenu;
    private MyViewPager main_vp;

    private List<Fragment> vp_fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);

        BitmapHelper.init(this);

        //slidingMenu
        slidingMenu = new SlidingMenu(SearchActivity.this);
        /**slidingMenu的相关设置*/
        initSlidingMenu();

        init();

        //main_vp
        main_vp = ((MyViewPager) findViewById(R.id.main_vp));
        //设置适配器
        main_vp.setAdapter(new Adapter_MainVp(getSupportFragmentManager()));

        /**设置监听事件*/
        setListeners();
    }

    /**main_vp的适配器*/
    class Adapter_MainVp extends FragmentPagerAdapter {

        public Adapter_MainVp(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return vp_fragments.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    /**设置监听事件*/
    private void setListeners() {
        /**RadioGroup的点击监听事件。RadioButton与ViewPager对应*/
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rbIds.length; i++) {
                    if (rbIds[i] == checkedId) {
                        main_vp.setCurrentItem(i);
                    }
                }
            }
        });

        /**main_vp的监听事件,viewpager滑动，小绿条也滑动*/
        main_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < views.length; i++) {
                    if (position == i) {
                        views[i].setVisibility(View.VISIBLE);
                    } else {
                        views[i].setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /**头部左边按钮的点击监听事件,点击进入菜单左边部分*/
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.showMenu();
            }
        });

        /**头部右边按钮的点击监听事件*/
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**SlingMenu的相关设置*/
    private void initSlidingMenu() {
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        slidingMenu.setShadowWidth(R.dimen.shadow_width);
//        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setAboveOffsetRes(R.dimen.slidingmenu_offset);

        //获取手机屏幕的宽高信息
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels * 4 / 5;
        slidingMenu.setBehindWidth(width);
//        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMode(SlidingMenu.LEFT);
        //左边菜单的布局
        View view_menu_left = View.inflate(SearchActivity.this, R.layout.menu_left, null);
        slidingMenu.setMenu(view_menu_left);
    }

    /**控件的初始化方法*/
    private void init() {
        //头部左边按钮
        left = ((ImageView) findViewById(R.id.top_left_img));

        //头部右边按钮
        right = ((ImageView) findViewById(R.id.top_right_img));

        //对症下药那些RadioButton
        rg = ((RadioGroup) findViewById(R.id.search_rg));

        views[0] = findViewById(R.id.search_view1);
        views[1] = findViewById(R.id.search_view2);
        views[2] = findViewById(R.id.search_view3);

        //vp_fragments
        vp_fragments.add(Fragment_Medicine.getFragment());
        vp_fragments.add(Fragment_Sort.getFragment());
        vp_fragments.add(FragmentType.getFragment());
    }


}
