package org.insideranken.npcottner.recyclerviewexample01;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class languageRecyclerAdapter extends RecyclerView.Adapter<languageRecyclerAdapter.MyViewHolder>
{
    Context context;
    ArrayList<languageModel> languageModel;
    private final IndLanguageInterface indLanguageInterface;

    public languageRecyclerAdapter(Context context, ArrayList<languageModel> languageModel,
                                   IndLanguageInterface indLanguageInterface)
    {
        this.context = context;
        this.languageModel = languageModel;
        this.indLanguageInterface = indLanguageInterface;
    }

    //This is where we inflate the layout, give the look to each row.
    @NonNull
    @Override
    public languageRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row, parent, false);

        return new languageRecyclerAdapter.MyViewHolder(view, indLanguageInterface);
    }
    //Assign values to the views created in the row_layout file,
    //based on their position in the recyclerView
    @Override
    public void onBindViewHolder(@NonNull languageRecyclerAdapter.MyViewHolder holder, int position)
    {
        holder.tvLanguageName.setText(languageModel.get(position).getName());
        holder.tvLanguageYear.setText(languageModel.get(position).getYear());
        holder.ivLanguageImage.setImageResource(languageModel.get(position).getImageId());
    }
    //Count of the number of total items RecyclerView is to display
    @Override
    public int getItemCount() {
        return languageModel.size();
    }

    //This method grabs views from row_layout file
    //In a way, it is sort of like the onCreate() method
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLanguageName;
        TextView tvLanguageYear;
        ImageView ivLanguageImage;

        public MyViewHolder(View itemView, IndLanguageInterface recyclerViewInterface) {
            super(itemView);

            tvLanguageName = itemView.findViewById(R.id.tvLanguageName);
            tvLanguageYear = itemView.findViewById(R.id.tvLanguageYear);
            ivLanguageImage = itemView.findViewById(R.id.ivLanguageImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (indLanguageInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            indLanguageInterface.onItemClick(pos);
                        }
                    }

                }
            });
        }
    }
}
