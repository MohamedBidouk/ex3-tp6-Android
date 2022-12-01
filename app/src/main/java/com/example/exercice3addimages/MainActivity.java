package com.example.exercice3addimages;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recyclerview Holder
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //scrolling manager
        LinearLayoutManager LM = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(LM);
        //Data Source Creation

        Movie movie = new Movie("Mad Max: Fury Road", R.drawable.madmax);
        movieList.add(movie);
        movie = new Movie("Inside Out", R.drawable.madmax);
        movieList.add(movie);
        movie = new Movie("Star Wars: Episode VII - The Force Awakens",R.drawable.madmax);
        movieList.add(movie);


//Call Adapter
        myAdapter = new Adapter(movieList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getName()+"is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }
}