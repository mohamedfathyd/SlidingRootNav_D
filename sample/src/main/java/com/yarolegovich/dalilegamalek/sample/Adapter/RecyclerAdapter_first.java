package com.yarolegovich.dalilegamalek.sample.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yarolegovich.dalilegamalek.sample.Activity.List_activity;
import com.yarolegovich.dalilegamalek.sample.R;
import com.yarolegovich.dalilegamalek.sample.model.content_category;

import java.util.List;


public class RecyclerAdapter_first extends RecyclerView.Adapter<RecyclerAdapter_first.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<content_category> contactslist;


    public RecyclerAdapter_first(Context context, List<content_category> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

         myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/flat.ttf");

         holder.Name.setText(contactslist.get(position).getName());
         holder.Name.setTypeface(myTypeface);
         Glide.with(context).load(contactslist.get(position).getImage()).error(R.drawable.circlelogo).into(holder.image);
         holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context, List_activity.class);
                intent.putExtra("name",contactslist.get(position).getName());
                intent.putExtra("id",contactslist.get(position).getId());
                context.startActivity(intent);

                }

        });

    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView image;
    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.name);
        image=(ImageView)itemView.findViewById(R.id.photo);

    }
}}