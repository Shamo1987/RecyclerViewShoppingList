package com.info.recyclerviewshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.info.recyclerviewcalismasi.R;

import java.util.ArrayList;

public class EnkelRV extends AppCompatActivity {
    private ArrayList<String> countryList ;
    private RecyclerView rv;
    private EnkelRVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enkel_rv);

        rv = (RecyclerView) findViewById(R.id.enkelRV);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        countryList = new ArrayList<>();
        adapter = new EnkelRVAdapter(this, countryList);
        rv.setAdapter(adapter);

        addData();

    }

    public void addData(){


        countryList.add("Sweden");
        countryList.add("Turkey");
        countryList.add("Italy");
        countryList.add("Russia");

        adapter.notifyDataSetChanged();
    }
}
