package com.example.iipao2020_amst_1ep_g10apk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Resultado extends AppCompatActivity {
    private TextView tv;
    private EditText editText;
    private RequestQueue mQueue;
    private String url="https://superheroapi.com/api/6504227666269769/search/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        tv=(TextView)findViewById(R.id.Tvh);
        mQueue = Volley.newRequestQueue(this);
        editText=(EditText)findViewById(R.id.EditSearch);
        stringRequest();


    }
    private void stringRequest() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url+editText.getText(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        try {

                            tv.setText(response.getString("name"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + "6504227666269769");
                System.out.println("6504227666269769");
                return params;
            }
        };
        ;
        mQueue.add(request);
    }
}