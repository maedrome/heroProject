package com.example.iipao2020_amst_1ep_g10apk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.BtnSearch);

        button.setOnClickListener((view)-> {

                    startActivity(new Intent(MainActivity.this, Resultado.class));
                }

        );

    }

}