package com.health.yaopintong.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.health.yaopintong.R;
import com.health.yaopintong.beans.Type;
import com.health.yaopintong.helpers.BitmapHelper;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * 品牌专区首页的适配器
 */
public class TypeAdapter extends BaseAdapter {
    private List<Type> list;
    private Context context;

    public TypeAdapter(Context context, List<Type> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.type_gv_item, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        // 获取集合中的值
        Type items = list.get(position);
        System.out.println("-------items-------->"+items);
        holder.type_tv_name.setText(items.getNamecn());
        // 设置图片
        String imageUrl = items.getTitleimg();
        BitmapHelper.getUtils().display(holder.type_iv_imv, imageUrl);

        return convertView;
    }

    class ViewHolder {
        private TextView type_tv_name;
        private ImageView type_iv_imv;

        public ViewHolder(View itemView) {
            type_iv_imv = (ImageView) itemView
                    .findViewById(R.id.type_iv_imv);
            type_tv_name = (TextView) itemView.findViewById(R.id.type_tv_name);
        }
    }
}
