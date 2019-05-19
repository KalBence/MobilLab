package com.example.gamelist.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.ui.ItemClickListener;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    private Context context;
    private List<Game> gamesList;
    private ItemClickListener clickListener;

    public GamesAdapter(Context context, List<Game> gamesList) {
        this.context = context;
        this.gamesList = gamesList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_game, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game game = gamesList.get(position);
        if (game.getCoverUrl() != null) {
            Glide.with(context).load(game.getCoverUrl()).into(holder.ivImage);
        }
        holder.tvName.setText(game.getName());
        String rating = "N/A";
        if (game.getRating() != null)
            rating = game.getRating().toString();

        holder.tvRating.setText(rating);
    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivImage;
        public TextView tvName;
        public TextView tvRating;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvRating = itemView.findViewById(R.id.tvRating);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

