package com.example.itsyournews.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.itsyournews.R;
import com.example.itsyournews.adapter.ArticleAdapter;
import com.example.itsyournews.model.Article;
import com.example.itsyournews.view_model.ArticleViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG =MainActivity.class.getSimpleName();

    private ShimmerFrameLayout shimmerFrameLayout;
    private RecyclerView recycler_view;
    private ProgressBar progress_bar;

    private LinearLayoutManager layoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    public Application application;
    ArticleViewModel articleViewModel ;
    private ArticleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getArticles();

    }

    private void getArticles() {
        articleViewModel.getBashboardNewsResponseLiveData().observe(this, articleResponse -> {
            if(articleResponse!=null && articleResponse.getArticles()!=null
            && !articleResponse.getArticles().isEmpty()){
//                progress_bar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                recycler_view.setVisibility(View.VISIBLE);

            }

        });
    }

    private void init() {
//        progress_bar = findViewById(R.id.progress_bar);
        shimmerFrameLayout =findViewById(R.id.shimmerLayout);
        shimmerFrameLayout.startShimmer();

        recycler_view=findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler_view.setLayoutManager(layoutManager);

        recycler_view.setHasFixedSize(true);

        adapter = new ArticleAdapter(MainActivity.this,articleArrayList);
        recycler_view.setAdapter(adapter);
//        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);
        articleViewModel= (ArticleViewModel) ViewModelProviders.of(this).get(new ArticleViewModel(application).getClass());
//        articleViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
//                .getInstance(getApplication()))
//                .get(ArticleViewModel.class);
//        articleViewModel = new ArticleViewModel(this, AndroidViewModelFactory.getInstance(getApplication())).get(ArticleViewModel.class);

    }
}