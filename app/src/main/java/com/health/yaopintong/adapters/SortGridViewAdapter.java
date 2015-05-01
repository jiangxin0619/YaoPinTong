package com.health.yaopintong.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.health.yaopintong.R;
import com.health.yaopintong.myview.NoScrollGridView;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-30.
 */
public class SortGridViewAdapter extends BaseAdapter {
    private ArrayList<String > datas;
    private LayoutInflater inflater;
    private Context context;

    public SortGridViewAdapter(ArrayList<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
        //初始化布局填充器
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.sort_lv_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        final ViewHolder holder = (ViewHolder) convertView.getTag();
        NoScrollGridView sort_gv_content = (NoScrollGridView) parent.findViewById(R.id.sort_gv_content);
        Log.i("mytest","-=-=-=-=-=-=-=-=-=-=-=-"+sort_gv_content);
        sort_gv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,datas.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        holder.sort_tv_item.setText(datas.get(position));
        return convertView;
    }
    public class ViewHolder {
        private TextView sort_tv_item;
        public ViewHolder(View itemView){
            sort_tv_item= (TextView) itemView.findViewById(R.id.sort_tetv_item);
        }
    }
}
