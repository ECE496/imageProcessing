package com.example.android.camera2basic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PieChart pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        List<PieEntry> value = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        float neutral = extras.getFloat("neutral");
        float happy = extras.getFloat("happy");
        float sad = extras.getFloat("sad");
        float surprise = extras.getFloat("surprise");
        float fear = extras.getFloat("fear");
        float disgust = extras.getFloat("disgust");
        float anger = extras.getFloat("angry");

        value.add(new PieEntry(neutral, "Neutral"));
        value.add(new PieEntry(happy, "Happy"));
        value.add(new PieEntry(sad, "Sad"));
        value.add(new PieEntry(surprise, "Surprise"));
        value.add(new PieEntry(fear, "Fear"));
        value.add(new PieEntry(disgust, "Disgust"));
        value.add(new PieEntry(anger, "Anger"));

        PieDataSet pieDataSet = new PieDataSet(value, "Emotion Distribution");

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        pieChart.animateXY(1400, 1400);

    }

}
