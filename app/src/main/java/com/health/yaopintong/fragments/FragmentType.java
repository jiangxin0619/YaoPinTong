package com.health.yaopintong.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.health.yaopintong.R;
import com.health.yaopintong.activities.TypeGridConActivity;
import com.health.yaopintong.adapters.TypeAdapter;
import com.health.yaopintong.beans.Type;
import com.health.yaopintong.data.DataUrl;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌专区
 */
public class FragmentType extends Fragment {
    private GridView gridView;
    private List<Type> list;

    public static FragmentType getFragment() {
        FragmentType fragmentContent = new FragmentType();
        return fragmentContent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewUtils.inject(getActivity());
        View view = inflater.inflate(R.layout.type_gv, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        gridView = (GridView) view.findViewById(R.id.type_gv);

        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, DataUrl.TYPEINDEX, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                try {
                    JSONObject object = new JSONObject(objectResponseInfo.result);
                    JSONArray array = object.getJSONArray("results");
                    list = new ArrayList<>();
                    for (int i = 0; i < array.length(); i++) {
                        Type type = new Type();
                        JSONObject object1 = array.getJSONObject(i);
                        String namecn = object1.getString("namecn");
                        String titleimg = object1.getString("titleimg");
                        type.setNamecn(namecn);
                        type.setTitleimg(titleimg);
                        list.add(type);
                    }
                    System.out.println("******list*****>"+list);
                    TypeAdapter typeAdapter = new TypeAdapter(getActivity(), list);
                    gridView.setAdapter(typeAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });

        //设置GridView的点击事件
        setListeners();

    }

    private void setListeners() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TypeGridConActivity.class);
                intent.putExtra("brand",list.get(position).getNamecn());
                startActivity(intent);
            }
        });
    }

}
