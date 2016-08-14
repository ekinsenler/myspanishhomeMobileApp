package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.dpointgroup.myspanishhome.myspanishhomemobileapp.App.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    //Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    //Rooms request URL;
    private String URL = "http://10.0.2.2:8888/mySpanishHome/scripts/roomRequest.php";
    private ProgressDialog pDialog;
    private List<Room> roomList = new ArrayList<Room>();
    private ListView lv;
    private RoomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.room_lv);
        adapter = new RoomAdapter(this, roomList);
        lv.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        //Process Dialog before request
        pDialog.setMessage("Loading...");
        pDialog.show();
        /*
        StringRequest roomRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    Log.d(TAG, response.toString());
                    hidePDialog();
                    //Parsing JSON
                    JSONArray rl = new JSONArray(response);
                    for (int i = 0; i<rl.length(); i++)
                    {
                        JSONObject obj = rl.getJSONObject(i);
                        Room r = new Room();
                        r.setTitle(obj.getString("title"));
                        r.setRating(((Number) obj.get("rating"))
                                .floatValue());
                        r.setPrice(((Number) obj.get("price"))
                                .floatValue());
                        roomList.add(r);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });
        */

        JsonArrayRequest roomRequest = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();
                        //Parsing JSON
                        for (int i = 0; i < response.length(); i++)
                        {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Room r = new Room();
                                r.setTitle(obj.getString("title"));
                                r.setRating(((Number) obj.get("rating"))
                                        .floatValue());
                                r.setPrice(((Number) obj.get("price"))
                                        .floatValue());
                                r.setThumbnailURL(obj.getString("thumbNailURL"));
                                roomList.add(r);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });

        //Adding Currently Created Request to request queue
        AppController.getInstance().addToRequestQueue(roomRequest);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
