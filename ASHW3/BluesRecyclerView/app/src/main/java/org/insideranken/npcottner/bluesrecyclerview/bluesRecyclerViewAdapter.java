package org.insideranken.npcottner.bluesrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bluesRecyclerViewAdapter extends
        RecyclerView.Adapter<bluesRecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<BluesModel> bluesModel;
    private final BluesRecyclerViewInterface recyclerViewInterface;

    public bluesRecyclerViewAdapter(Context context, ArrayList<BluesModel> bluesModel,
                                    BluesRecyclerViewInterface recyclerViewInterface)
    {
        this.context = context;
        this.bluesModel = bluesModel;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    //This is where we inflate the layout, give the look to each row.
    @NonNull
    @Override
    public bluesRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);

        return new bluesRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    //Assign values to the views created in the row_layout file,
    //based on their position in the recyclerView
    @Override
    public void onBindViewHolder(@NonNull bluesRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvPlayerName.setText(bluesModel.get(position).getBluesName());
        holder.tvPlayerNumber.setText(bluesModel.get(position).getBluesNumber());
        holder.tvPlayerPosition.setText(bluesModel.get(position).getBluesPosition());
        holder.ivPlayerImage.setImageResource(bluesModel.get(position).getBluesImage());
    }

    //Count of the number of total items RecyclerView is to display
    @Override
    public int getItemCount() {
        return bluesModel.size();
    }

    //This method grabs views from row_layout file
    //In a way, it is sort of like the onCreate() method
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlayerName;
        TextView tvPlayerNumber;
        TextView tvPlayerPosition;
        ImageView ivPlayerImage;

        public MyViewHolder(View itemView, BluesRecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            tvPlayerName = itemView.findViewById(R.id.tvPlayerName);
            tvPlayerNumber = itemView.findViewById(R.id.tvPlayerNumber);
            tvPlayerPosition = itemView.findViewById(R.id.tvPlayerPosition);
            ivPlayerImage = itemView.findViewById(R.id.ivPlayerImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemLongClick(pos);
                        }
                    }
                    return true;
                }
            });
        }
    }
}
