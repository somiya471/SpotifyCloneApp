package com.example.practicespotify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList title_id,artist_id,image_id;

    public RecyclerAdapter(Context context, ArrayList title_id, ArrayList artist_id, ArrayList image_id) {
        this.context = context;
        this.title_id = title_id;
        this.artist_id = artist_id;
        this.image_id = image_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title_set.setText(String.valueOf(title_id.get(position)));
        holder.artist_set.setText(String.valueOf(artist_id.get(position)));
        holder.img_set.setImageResource((Integer) image_id.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(context,SongPlayActivity.class);
                iNext.putExtra("title",String.valueOf(title_id.get(position)));
                iNext.putExtra("artist",String.valueOf(artist_id.get(position)));
                iNext.putExtra("image",(Integer) image_id.get(position));
                context.startActivity(iNext);

            }
        });


    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_set,artist_set;
        ImageView img_set;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_set = itemView.findViewById(R.id.title_text);
            artist_set = itemView.findViewById(R.id.artist_text);
            img_set = itemView.findViewById(R.id.img);
        }
    }
}
