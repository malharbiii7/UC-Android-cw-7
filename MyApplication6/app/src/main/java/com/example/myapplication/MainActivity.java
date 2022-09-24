package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Restaurant> myList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Restaurant resturant1 = new Restaurant("big mac", 2, R.drawable.img );
         Restaurant resturant2 = new Restaurant("McRoyale", 2, R.drawable. img_1);
        Restaurant resturant3 = new Restaurant("McChicken", 2, R.drawable.img_2);
        Restaurant resturant4 = new Restaurant("Chicken Nuggets", 1.200, R.drawable. img_3);
        Restaurant resturant5 = new Restaurant("Fries", 1, R.drawable.img_4);


        myList.add(resturant1);
        myList.add(resturant2);
        myList.add(resturant3);
        myList.add(resturant4);
        myList.add(resturant5);


        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager( this);
        recycler.setLayoutManager(manager);


        ItemAdapter adapter = new ItemAdapter(myList,  this);
        recycler.setAdapter(adapter);

            }
        }