package com.example.ankit.recyclerviewwithsearchview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ankit on 17/9/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

   ArrayList<Hero> arrayList = new ArrayList<>();

    RecyclerAdapter(ArrayList<Hero> arrayList)
    {
         this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.c_image.setImageResource(arrayList.get(position).getImage_id());
        holder.c_name.setText(arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView c_image;
        TextView c_name;

        public MyViewHolder(View itemView) {
            super(itemView);

            c_image = (ImageView) itemView.findViewById(R.id.image);
            c_name = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public void setFilter(ArrayList<Hero> newList )
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }
}
