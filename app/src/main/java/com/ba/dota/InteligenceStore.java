package com.ba.dota;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class InteligenceStore extends AppCompatActivity {

    ListView listView;
    List<Hero> list;
    HeroSAdapte strength;

    public static final String url = "https://www.dropbox.com/s/kgnfs1pw9em7tq4/Intelligence.json?dl=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inteligence_store);

        listView = (ListView) findViewById(R.id.list_ishop);
        Button button= (Button) findViewById(R.id.btn_ilist);


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        JsonRequest jsonRequest = new JsonRequest(Request.Method.GET, url, null, new Response.Listener() {
            @Override
            public void onResponse(Object response) {


                String json = response.toString();
                list = JsonHero.Item(json);
                strength = new HeroSAdapte(list, getApplicationContext());
                listView.setAdapter(strength);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (list.get(position).getName()) {

                            case ("Ancient Apparition"):
                                break;

                            case ("Bane"):

                                break;
                            case ("Batrider"):

                                break;
                            case ("Chen"):

                                break;
                            case ("Crystal Maiden"):

                                break;
                            case ("Dark Seer"):

                                break;
                            case ("Dark Willow"):

                                break;
                            case ("Dazzle"):

                                break;
                            case ("Death Prophet"):

                                break;
                            case ("Disruptor"):

                                break;
                            case ("Enchantress"):

                                break;
                            case ("Enigma"):

                                break;
                            case ("Grimstroke"):

                                break;
                            case ("Invoker"):

                                break;
                            case ("Jakiro"):

                                break;
                            case ("Keeper Of The Light"):

                                break;
                            case ("Leshrac"):

                                break;
                            case ("Lich"):

                                break;
                            case ("Lina"):

                                break;
                            case ("Lion"):

                                break;
                            case ("Nature Prophet"):

                                break;
                            case ("Necrophos"):

                                break;
                            case ("Ogre Magi"):

                                break;
                            case ("Oracle"):

                                break;
                            case ("Outworld Devourer"):

                                break;
                            case ("Pugna"):

                                break;
                            case ("Puck"):

                                break;
                            case ("Queen Of Pain"):

                                break;
                            case ("Rubick"):

                                break;
                            case ("Shadow Demon"):

                                break;
                            case ("Shadow Shaman"):

                                break;
                            case ("Silencer"):

                                break;
                            case ("Skywrath Mage"):

                                break;
                            case ("Storm Spirit"):

                                break;
                            case ("Techies"):

                                break;
                            case ("Tinker"):

                                break;
                            case ("Visage"):

                                break;
                            case ("Warlock"):

                                break;
                            case ("Windranger"):

                                break;
                            case ("Winter Wyvern"):

                                break;
                            case ("Witch Doctor"):

                                break;
                            case ("Zeus"):

                                break;

                            default:
                                break;

                        }


                    }
                });


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Response parseNetworkResponse(NetworkResponse response) {
                try {
                    String jsonString = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers));
                    return Response.success(new JSONArray(jsonString),
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException je) {
                    return Response.error(new ParseError(je));
                }
            }

            @Override
            public int compareTo(@NonNull Object o) {
                return 0;
            }
        };
        requestQueue.add(jsonRequest);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InteligenceStore.this, ShowList.class));
            }
        });

    }
}
