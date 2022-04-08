package org.insideranken.npcottner.moviedatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public Context context;
    Activity activity;
    public ArrayList movie_id;
    public ArrayList movie_title;
    public ArrayList movie_director;
    public ArrayList movie_length;

    MyAdapter(Activity activity, Context context,
                     ArrayList movie_id,
                     ArrayList movie_title,
                     ArrayList movie_director,
                     ArrayList movie_length) {
        this.activity = activity;
        this.context = context;
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_director = movie_director;
        this.movie_length = movie_length;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.movieID.setText(String.valueOf(movie_id.get(position)));
        holder.movieTitle.setText(String.valueOf(movie_title.get(position)));
        holder.movieDirector.setText(String.valueOf(movie_director.get(position)));
        holder.movieLength.setText(String.valueOf(movie_length.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id",String.valueOf(movie_id.get(holder.getAdapterPosition())));
                intent.putExtra("title",String.valueOf(movie_title.get(holder.getAdapterPosition())));
                intent.putExtra("director", String.valueOf(movie_director.get(holder.getAdapterPosition())));
                intent.putExtra("length",String.valueOf(movie_length.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movie_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView movieID;
        TextView movieTitle;
        TextView movieDirector;
        TextView movieLength;

        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movieID = itemView.findViewById(R.id.movieID);
            movieTitle = itemView.findViewById(R.id.movieTitle);
            movieDirector = itemView.findViewById(R.id.movieDirector);
            movieLength = itemView.findViewById(R.id.movieLength);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
