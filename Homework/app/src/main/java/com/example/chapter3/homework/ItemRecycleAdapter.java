package com.example.chapter3.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemRecycleAdapter extends RecyclerView.Adapter<ItemRecycleAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> friends;

    public ItemRecycleAdapter(Context context, ArrayList<String> friends) {
        this.context = context;
        this.friends = friends;
    }

    @NonNull
    @Override
    public ItemRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = View.inflate(context, R.layout.new_list_item, null);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(i);
    }



    @Override
    public int getItemCount() {
        return friends.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;

        public MyViewHolder(View itemview) {
            super(itemview);
            itemName = (TextView) itemview.findViewById(R.id.tv_item_number);
        }

        public void bind(int position) {
            String data = friends.get(position);
            itemName.setText(data);
        }
    }
}
