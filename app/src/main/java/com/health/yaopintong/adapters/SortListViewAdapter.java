package com.health.yaopintong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.health.yaopintong.R;
import com.health.yaopintong.beans.Sort_Item;
import com.health.yaopintong.myview.NoScrollGridView;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-30.
 */
public class SortListViewAdapter extends BaseAdapter {
    private ArrayList<Sort_Item> datas;
    //    private LayoutInflater inflater;
    private Context context;
private  int i;
    public SortListViewAdapter(ArrayList<Sort_Item> datas, Context context,int i) {
        this.datas = datas;
        this.context = context;
        this.i=i;
        //初始化布局填充器
//        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.sort_lv_content, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.sort_gv_content.setAdapter(new SortGridViewAdapter(datas.get(position).getContent(), context));
        holder.sort_tv_item.setText("              "+datas.get(position).getName());
//        holder.sort_gv_content.setClickable(false);
//        holder.sort_gv_content.setPressed(false);
//        holder.sort_gv_content.setEnabled(false);

        holder.sort_tv_item.setBackgroundResource(datas.get(position).getAfterBackground());
//        holder.sort_gv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("mytest","i是    "+i+"           position 是    "+position);
//                Toast.makeText(context, "" +datas.get(i).getContent().get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
        return convertView;
    }

    public class ViewHolder {
        private TextView sort_tv_item;
        private NoScrollGridView sort_gv_content;

        public ViewHolder(View itemView) {
            sort_tv_item = (TextView) itemView.findViewById(R.id.sort_tv_item);
            sort_gv_content = (NoScrollGridView) itemView.findViewById(R.id.sort_gv_content);
        }
    }
}
