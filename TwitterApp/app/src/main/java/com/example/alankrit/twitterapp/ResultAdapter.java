package com.example.alankrit.twitterapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Alankrit on 07-Jul-17.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    ArrayList<Statuses> arrayList;
    Context c;

    public ResultAdapter(ArrayList<Statuses> arrayList, Context c) {
        this.arrayList = arrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.single_list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Statuses s=arrayList.get(position);
        holder.screenName.setText(s.getUser().getScreen_name());
        holder.name.setText(s.getUser().getName());
        holder.userId.setText(s.getUser().getUser_id());
        holder.text.setText(s.getText());
        holder.link.setPaintFlags(holder.link.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        holder.link.setText(s.getLink());
        Picasso.with(c)
                .load(s.getUser().getProfile_image_url_https())
                .into(holder.imageView);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                IntentFilter intentfilter=new IntentFilter();
//                intentfilter.addAction(Intent.CATEGORY_APP_BROWSER);

                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(s.getLink()));
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView screenName,name,userId,link,text;
        ImageView imageView;
        CardView cardview;
        public ViewHolder(View v) {
            super(v);
            screenName= (TextView) v.findViewById(R.id.screenName);
            name= (TextView) v.findViewById(R.id.actualName);
            userId= (TextView) v.findViewById(R.id.id);
            link= (TextView) v.findViewById(R.id.link);
            text= (TextView) v.findViewById(R.id.text);
            imageView= (ImageView) v.findViewById(R.id.image);
            cardview= (CardView) v.findViewById(R.id.cardView);
        }
    }
}
