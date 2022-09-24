package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nametext = findViewById(R.id.textView);
        TextView pricetext = findViewById(R.id.textView2);
        ImageView img = findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();

        Restaurant sentRes = (Restaurant) bundle.getSerializable("restaurant");


        nametext.setText(sentRes.getMealName());
        pricetext.setText(sentRes.getMealPrice() +"KD");
        img.setImageResource(sentRes.getMealImg());

    }
}