package com.info.recyclerviewshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.info.recyclerviewcalismasi.R;

import java.util.ArrayList;

public class DetailRV extends AppCompatActivity {

    private ArrayList<Movies> moviesList;
    private RecyclerView rv;
    private DetailRVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rv);


        rv = (RecyclerView) findViewById(R.id.detayliRV);
        rv.setHasFixedSize(true);


        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        moviesList = new ArrayList<>();

        moviesList.add(new Movies("Anadoluda",15.99,"birzamanlaranadoluda"));
        moviesList.add(new Movies("Django",19.99,"django"));
        moviesList.add(new Movies("Inception",24.99,"inception"));
        moviesList.add(new Movies("Interstellar",15.99,"interstellar"));
        moviesList.add(new Movies("The Hateful Eight",12.99,"thehatefuleight"));
        moviesList.add(new Movies("The Pianist",4.99,"thepianist"));

        adapter = new DetailRVAdapter(this, moviesList);

        rv.setAdapter(adapter);
    }
}
