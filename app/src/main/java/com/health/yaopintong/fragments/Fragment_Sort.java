package com.health.yaopintong.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.TextView;

import com.health.yaopintong.R;
import com.health.yaopintong.adapters.SortListViewAdapter;
import com.health.yaopintong.beans.Sort_Item;
import com.health.yaopintong.myview.MyListView;
import com.health.yaopintong.myview.NoScrollGridView;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-30.
 */
public class Fragment_Sort extends Fragment {
    private ArrayList<String> items;
    private ArrayList<Sort_Item> data;
    private NoScrollGridView sort_gv_content;
    private TextView sort_tv_item;
    private  int i=0;
    private SortListViewAdapter adapter;


    public static Fragment_Sort getFragment() {
        Fragment_Sort fragment_sort = new Fragment_Sort();

        return fragment_sort;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
//        initItem();
        initData();
        MyListView sort_lv_total = (MyListView) view.findViewById(R.id.sort_lv_total);
        adapter = new SortListViewAdapter(data, getActivity(), i);
        sort_lv_total.setAdapter(adapter);
        sort_lv_total.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sort_gv_content = (NoScrollGridView) view.findViewById(R.id.sort_gv_content);
                sort_tv_item = (TextView) view.findViewById(R.id.sort_tv_item);
                if (position == id) {
        i=position;
//                    adapter.notifyDataSetInvalidated();
                    Log.i("mytest","------这里的i值是"+i);
                    switch (sort_gv_content.getVisibility()) {
                        case NoScrollGridView.VISIBLE:
                            Log.i("mytest",""+data.get(position).getAfterBackground());
                            sort_tv_item.setBackgroundResource(data.get(position).getAfterBackground());
                            sort_gv_content.setVisibility(NoScrollGridView.GONE);
                            break;
                        case NoScrollGridView.GONE:
                            sort_tv_item.setBackgroundResource(data.get(position).getLaterBackground());
                            sort_gv_content.setVisibility(NoScrollGridView.VISIBLE);
                            break;

                    }

                }

            }
        });

        return view;
    }

    private void initData() {
        data = new ArrayList<>();

        Sort_Item item_1 = new Sort_Item();
        ArrayList<String> list_1 = new ArrayList<>();
        list_1.add("跌打损伤");
        list_1.add("跌伤烫伤");
        list_1.add("晕车晕船");
        list_1.add("皮肤湿疹");
        list_1.add("消化不良");
        list_1.add("咽痛音哑");
        list_1.add("口舌生疮");
        item_1.setName("家庭药箱");
        item_1.setContent(list_1);
        item_1.setAfterBackground(R.drawable.bg_btn_home_drug);
        item_1.setLaterBackground(R.drawable.bg_btn_home_drug_press);
        data.add(item_1);

        Sort_Item item_2 = new Sort_Item();
        ArrayList<String> list_2 = new ArrayList<>();
        list_2.add("解热镇痛");
        list_2.add("病毒性感冒");
        list_2.add("驱风祛暑");
        list_2.add("清热解毒");
        item_2.setName("感冒用药");
        item_2.setContent(list_2);
        item_2.setAfterBackground(R.drawable.bg_btn_cold_drug);
        item_2.setLaterBackground(R.drawable.bg_btn_cold_drug_press);
        data.add(item_2);

        Sort_Item item_3 = new Sort_Item();
        ArrayList<String> list_3 = new ArrayList<>();
        list_3.add("补钙补锌");
        list_3.add("补铁补硒");
        list_3.add("复合维生素");
        list_3.add("叶酸类");
        item_3.setName("维生素/钙");
        item_3.setContent(list_3);
        item_3.setAfterBackground(R.drawable.bg_btn_vitamin_drug);
        item_3.setLaterBackground(R.drawable.bg_btn_vitamin_drug_press);
        data.add(item_3);

        Sort_Item item_4 = new Sort_Item();
        ArrayList<String> list_4 = new ArrayList<>();
        list_4.add("心脑血管药");
        list_4.add("糖尿病用药");
        list_4.add("肠胃用药");
        list_4.add("呼吸系统药");
        item_4.setName("慢性病药");
        item_4.setContent(list_4);
        item_4.setAfterBackground(R.drawable.bg_btn_chronic_drug);
        item_4.setLaterBackground(R.drawable.bg_btn_chronic_drug_press);
        data.add(item_4);

        Sort_Item item_5 = new Sort_Item();
        ArrayList<String> list_5 = new ArrayList<>();
        list_5.add("阴道炎");
        list_5.add("月经不调");
        list_5.add("痛经");
        list_5.add("更年期综合症");
        list_5.add("白带异常");
        list_5.add("女性不孕");
        item_5.setName("妇科用药");
        item_5.setContent(list_5);
        item_5.setAfterBackground(R.drawable.bg_btn_gynae_drug);
        item_5.setLaterBackground(R.drawable.bg_btn_gynae_drug_press);
        data.add(item_5);

        Sort_Item item_6 = new Sort_Item();
        ArrayList<String> list_6 = new ArrayList<>();
        list_6.add("前列腺用药");
        list_6.add("阳痿早泄");
        list_6.add("滑精遗精");
        list_6.add("脱发斑秃");
        list_6.add("男性不育");
        item_6.setName("男科用药");
        item_6.setContent(list_6);
        item_6.setAfterBackground(R.drawable.bg_btn_man_drug);
        item_6.setLaterBackground(R.drawable.bg_btn_man_drug_press);
        data.add(item_6);

        Sort_Item item_7 = new Sort_Item();
        ArrayList<String> list_7 = new ArrayList<>();
        list_7.add("小儿感冒发烧");
        list_7.add("小儿止咳化痰");
        list_7.add("小二肠胃用药");
        list_7.add("小二止泻用药");
        item_7.setName("儿童用药");
        item_7.setContent(list_7);
        item_7.setAfterBackground(R.drawable.bg_btn_child_drug);
        item_7.setLaterBackground(R.drawable.bg_btn_child_drug_press);
        data.add(item_7);

    }

}
