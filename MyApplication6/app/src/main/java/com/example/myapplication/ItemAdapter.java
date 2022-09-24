package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter  {

    ArrayList<Restaurant> myList = new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<Restaurant> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent, false);
        ViewHolder vh = new ViewHolder(view);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).img.setImageResource(myList.get(position).getMealImg());
        ((ViewHolder)holder).name.setText(myList.get(position).getMealName());
        ((ViewHolder)holder).price.setText(myList.get(position).getMealPrice() + "KD");
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, activity_details.class);
                intent.putExtra("restaurant", (Parcelable) myList.get(position));
                context .startActivity(intent);


            }
        });

        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this)
                        .setTitle("Attention")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myList.remove(position);
                                notifyDataSetChanged();
                            }
                        })

                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();;
                            }
                        });




            }
        });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img, delete;
        TextView name, price;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            img = v.findViewById(R.id.imageView);
            name = v.findViewById(R.id.textView);
            price = v.findViewById(R.id.textView2);
            delete = v.findViewById(R.id.);

        }
    }
}
