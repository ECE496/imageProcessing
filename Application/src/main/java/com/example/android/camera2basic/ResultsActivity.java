package com.example.android.camera2basic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
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
        BarChart barChart = findViewById(R.id.barchart);

        //List<PieEntry> value = new ArrayList<>();
        List<BarEntry> entries= new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        float neutral = extras.getFloat("neutral");
        float happy = extras.getFloat("happy");
        float sad = extras.getFloat("sad");
        float surprise = extras.getFloat("surprise");
        float fear = extras.getFloat("fear");
        float disgust = extras.getFloat("disgust");
        float anger = extras.getFloat("angry");

        //value.add(new PieEntry(neutral, "Neutral"));
        //value.add(new PieEntry(happy, "Happy"));
        //value.add(new PieEntry(sad, "Sad"));
        //value.add(new PieEntry(surprise, "Surprise"));
        //value.add(new PieEntry(fear, "Fear"));
        //value.add(new PieEntry(disgust, "Disgust"));
        //value.add(new PieEntry(anger, "Anger"));

        entries.add(new BarEntry(0f, neutral));
        entries.add(new BarEntry(1f, happy));
        entries.add(new BarEntry(2f, sad));
        entries.add(new BarEntry(3f, surprise));
        entries.add(new BarEntry(4f, fear));
        entries.add(new BarEntry(5f, disgust));
        entries.add(new BarEntry(6f, anger));

        BarDataSet set = new BarDataSet(entries, "Emotion Distribution");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        barChart.animateXY(1400,1400);
        barChart.invalidate(); // refresh

        // the labels that should be drawn on the XAxis
        final String[] quarters = new String[] { "Neutral", "Happy", "Sad", "Surprise","Fear","Disgust","Anger" };

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(quarters));
        xAxis.setGranularity(1); // minimum axis-step (interval) is 1
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        //PieDataSet pieDataSet = new PieDataSet(value, "Emotion Distribution");
        //PieData pieData = new PieData(pieDataSet);
        //pieChart.setData(pieData);
        //pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        //pieChart.animateXY(1400, 1400);

    }

    class MyXAxisValueFormatter implements IAxisValueFormatter {

        private String[] mValues;

        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return mValues[(int) value];
        }
    }

}
