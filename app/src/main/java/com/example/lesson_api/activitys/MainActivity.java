package com.example.lesson_api.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson_api.R;
import com.example.lesson_api.adapters.StateAdapter;
import com.example.lesson_api.models.State;
import com.example.lesson_api.services.DataService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StateAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.res);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recycle view code
        //statepic,statename,statenative

        ArrayList<State> arrState = DataService.getArrState();

        for(State s : arrState){

            Log.d("result", s.getFlag());
        }

        adapter = new StateAdapter(this,arrState);
        recyclerView.setAdapter(adapter);
    }
}