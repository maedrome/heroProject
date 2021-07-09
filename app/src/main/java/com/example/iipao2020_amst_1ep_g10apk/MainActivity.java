package com.example.iipao2020_amst_1ep_g10apk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button BtnSearch;
    private EditText txtSearch;
    private ArrayList<String> listaheroes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnSearch =(Button)findViewById(R.id.BtnSearch);
        txtSearch = (EditText)findViewById(R.id.EditSearch);
        BtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtSearch.getText().toString();
                if (nombre != null && !nombre.equals("")){
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    String url ="https://superheroapi.com/api/6504227666269769/search/" + nombre;
                    // Request a string response from the provided URL.
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        JSONArray heroes = response.getJSONArray("results");
                                        Intent intent = new Intent(MainActivity.this, Resultado.class);
                                        intent.putExtra("heroes", heroes.toString());
                                        startActivity(intent);
                                    } catch (JSONException e) {
                                        System.out.println(e.toString());
                                        Toast.makeText(MainActivity.this, "Error en los resultados", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error.toString());
                            Toast.makeText(MainActivity.this, "Algo ha salido mal", Toast.LENGTH_SHORT).show();
                        }
                    });
                    queue.add(request);
                } else {
                    Toast.makeText(MainActivity.this, "Escribe un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}



