package com.yarolegovich.dalilegamalek.sample.Adapter;

import android.app.Activity;
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
import com.yarolegovich.dalilegamalek.sample.Activity.show;
import com.yarolegovich.dalilegamalek.sample.R;
import com.yarolegovich.dalilegamalek.sample.model.contact_order;

import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_order> contactslist;

    public RecyclerAdapter(Context context, List<contact_order> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

     //    myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/flat.ttf");
        Calligrapher calligrapher = new Calligrapher(context);
        calligrapher.setFont((Activity) context, "Droid.ttf", true);
       holder.Name.setText(contactslist.get(position).getName());
       holder.likes.setText(contactslist.get(position).getLikes()+" معجب بهذا ");
     //    holder.Name.setTypeface(myTypeface);
         Glide.with(context).load(contactslist.get(position).getImage()).error(R.drawable.circlelogo).into(holder.image);

         holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=contactslist.get(position).getId();
                    String name=contactslist.get(position).getName();
                    int point=contactslist.get(position).getPoints();
                    String price=contactslist.get(position).getPrice();
                    String image=contactslist.get(position).getImage();
                    Intent intent=new Intent(context, show.class);
                    intent.putExtra("name",name);
                    intent.putExtra("image",image);
                    intent.putExtra("point",point);
                    intent.putExtra("price",price);
                    intent.putExtra("id",id);
                    intent.putExtra("address",contactslist.get(position).getAddress());
                intent.putExtra("city",contactslist.get(position).getCity());
                intent.putExtra("country",contactslist.get(position).getCountry());
                intent.putExtra("likes",contactslist.get(position).getLikes());
                intent.putExtra("details",contactslist.get(position).getDetails());
                intent.putExtra("category",contactslist.get(position).getCategory());
                intent.putExtra("phone",contactslist.get(position).getPhone());
                intent.putExtra("service_id",contactslist.get(position).getService_provider_id());
                    context.startActivity(intent);

            }
        });

    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,likes;
        ImageView image;

    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.txt_fish_title);
        image=(ImageView)itemView.findViewById(R.id.imageview3);
        likes=itemView.findViewById(R.id.ratingBar);

    }
}}