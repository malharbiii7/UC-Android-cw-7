package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        TextView nametext = findViewById(R.id.textViewnamed);
        TextView pricetext = findViewById(R.id.textViewpriced);
        ImageView img = findViewById(R.id.imageViewdetalis);

        Bundle bundle = getIntent().getExtras();

        Salon sentSalon = (Salon) bundle.getSerializable("salon");


        nametext.setText(sentSalon.getSalonName());
        pricetext.setText(sentSalon.getSalonPrice() +"KD");
        //img.setImageResource(sentSalon.getSalonImg());
        Picasso.with(this).load(sentSalon.getSalonImg()).into(img);
    }
}