package com.ba.dota;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa on 9/27/2018.
 */

public class JsonStrengthItem {


    public static List<Strengthlistitem> Item(String json) {

        List<Strengthlistitem> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonobject = jsonArray.getJSONObject(i);
                Strengthlistitem sli = new Strengthlistitem();

                sli.setItem_text(new String(jsonobject.getString("Text").getBytes("UTF-8")));
                sli.setUri_image(jsonobject.getString("Image"));
                sli.setCast(jsonobject.getString("Cast"));
                sli.setId(jsonobject.getInt("id"));


                list.add(sli);
            }
        } catch (JSONException|UnsupportedEncodingException  e) {
            e.printStackTrace();
        }


        return list;
    }


}
