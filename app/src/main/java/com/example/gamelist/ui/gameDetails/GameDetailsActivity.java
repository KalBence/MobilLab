package com.example.gamelist.ui.gameDetails;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gamelist.GameListApplication;
import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.model.GameViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class GameDetailsActivity extends AppCompatActivity implements GameDetailsScreen {

    @Inject
    GameDetailsPresenter detailsPresenter;

    private GameViewModel mGameViewModel;

    public GameDetailsActivity()  {
        GameListApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        String name =  getIntent().getStringExtra("name");
        Double rating =  getIntent().getDoubleExtra("rating", 0.0);
        String imageUrl =  getIntent().getStringExtra("imageUrl");
        String summary =  getIntent().getStringExtra("summary");
        String webpage = getIntent().getStringExtra("webpage");

        ImageView ivImage = findViewById(R.id.ivImage);
        if (imageUrl != null) {
            Glide.with(this).load(imageUrl).into(ivImage);
        }

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(name);
        TextView tvRating = findViewById(R.id.tvRating);
        tvRating.setText(Double.toString(rating));
        TextView tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(summary);
        tvSummary.setMovementMethod(new ScrollingMovementMethod());
        TextView tvWebpage = findViewById(R.id.tvWebpage);
        tvWebpage.setText(webpage);
    }

    @Override
    public void showGameDetails(Object gameDetails) {
        //TODO: show game details -  data in selectedGame
    }
}
