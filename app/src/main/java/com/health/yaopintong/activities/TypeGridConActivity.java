package com.health.yaopintong.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.health.yaopintong.R;

import java.util.ArrayList;
import java.util.List;

public class TypeGridConActivity extends ActionBarActivity {

    private Spinner type_spinner_price;
    private Spinner type_spinner_medcare;
    private Spinner type_spinner_basemed;
    private TextView brand_tv;

    private List<String> prices = new ArrayList<>();
    private List<String> medcare = new ArrayList<>();
    private List<String> basemed = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_grid_con);

        Intent intent = getIntent();
        //获取品牌专区的商标
        String brand = intent.getStringExtra("brand");

        /**初始化控件*/
        init();

        brand_tv.setText(brand);

        //spinner的相关设置
        initSpinner();
    }

    private void initSpinner() {
        type_spinner_price.setAdapter(new ArrayAdapter<String>(this,R.layout.type_spinner_item,prices));
        type_spinner_medcare.setAdapter(new ArrayAdapter<String>(this,R.layout.type_spinner_item,medcare));
        type_spinner_basemed.setAdapter(new ArrayAdapter<String>(this,R.layout.type_spinner_item,basemed));
    }

    private void init() {
        //商标名称
        brand_tv = ((TextView) findViewById(R.id.type_grid_brand));

        type_spinner_price = ((Spinner) findViewById(R.id.type_spinner_price));
        type_spinner_medcare = ((Spinner) findViewById(R.id.type_spinner_medcare));
        type_spinner_basemed = ((Spinner) findViewById(R.id.type_spinner_basemed));

        prices.add("不限制");
        prices.add("1-20元");
        prices.add("20-50元");
        prices.add("50-100元");
        prices.add("100-200元");
        prices.add("200元以上");

        medcare.add("不限制");
        medcare.add("医保药品");
        medcare.add("非医保药品");

        basemed.add("不限制");
        basemed.add("基本药物");
        basemed.add("非基本药物");
    }

}
