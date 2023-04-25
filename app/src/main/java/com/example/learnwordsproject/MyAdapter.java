package com.example.learnwordsproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<String> levelsArrList;

    public MyAdapter(Context context, ArrayList<String> levelsArrList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.levelsArrList = levelsArrList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);

        return new MyViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String levelNum = levelsArrList.get(position);
        holder.levelNumber.setText(levelNum);
        if(position < MainActivity.userProgress/30)
            holder.levelNumber.setBackgroundColor(Color.parseColor("#4CAF50"));
    }

    @Override
    public int getItemCount() {
        return levelsArrList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView levelNumber;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            levelNumber = itemView.findViewById(R.id.item_chapters_lessons_list);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
