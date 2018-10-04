package com.ba.dota;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mostafa on 9/27/2018.
 */

public class ListStoreStrength extends BaseAdapter {

    List<Strengthlistitem> list_view;
    Context context;

    DbUtil dbUtil;

    Items items;


    public ListStoreStrength(List<Strengthlistitem> list_view, Context context) {
        this.list_view = list_view;
        this.context = context;
    }



    @Override
    public int getCount() {
        return list_view.size();
    }

    @Override
    public Object getItem(int position) {
        return list_view.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        View v = View.inflate(context,R.layout.list_store,null);
        TextView textView = (TextView) v.findViewById(R.id.text_item);
        TextView cast = (TextView) v.findViewById(R.id.cast_item);
        final ImageView imageView = (ImageView) v.findViewById(R.id.image_item);
        Button button = (Button) v.findViewById(R.id.btn);


        textView.setText(list_view.get(position).getItem_text());
        cast.setText(list_view.get(position).getCast());


        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest request = new ImageRequest(list_view.get(position).getUri_image(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                imageView.setImageBitmap(response);


            }
        }, 160, 160, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbUtil = new DbUtil(context);
                dbUtil.getWritableDatabase();


                    items = new Items();

                    items.setItem_text(list_view.get(position).getItem_text());
                    items.setCast(list_view.get(position).getCast());
                    items.setUri_image(list_view.get(position).getUri_image());
                    items.setId(list_view.get(position).getId());


                    dbUtil.AddItem(items);


            }
        });


        return v;
    }


}
