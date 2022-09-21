package com.example.rest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Salon> myList = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://phoneshop-ddea0-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Salon salon4 = new Salon("Hair care", 6.500, R.drawable. img_3);




        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager( this);
        recycler.setLayoutManager(manager);

        ItemAdapter adapter = new ItemAdapter(myList,  this);
        recycler.setAdapter(adapter);

        final Query mysalon = dbRef.child("Salon");

        mysalon.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot a : snapshot.getChildren()){
                    Salon salon = a.getValue(Salon.class);
                    myList.add(salon);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}