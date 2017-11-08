package com.cs2340.team6.totallyratticalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class ChartActivity extends AppCompatActivity {

    ArrayList<RatSighting> markers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        LineChart chart = (LineChart) findViewById(R.id.chart); //code from demo code

        markers = CSVReader.getReports(); //from MapsActivity, initializes an array from the csv



        LineDataSet dataSet = new LineDataSet(getEntries(), "Label"); // add entries to dataset (from dem code)
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);  //from demo code
        dataSet.setDrawFilled(true); //from demo code

        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return (String.valueOf((int)value%12 + ((value%12==0) ? 12 : 0)) + "/" + String.valueOf((int)Math.floor((((value-1)/12)))));
            }
        });
        LineData lineData = new LineData(dataSet); //from demo code
        chart.setData(lineData); // from demo code
        chart.invalidate();

    }

    /**
     * Returns a count of the number of rat sightings on the given month/year
     *
     * @param month given month
     * @param year given year
     * @return the count
     */
    private int getCount(int month, int year){
        int count = 0;
        for (RatSighting r : markers) {
            if (onDate(r, month, year)){
                count ++;
            }
        }
        return count;
    }
    /**
     * checks if date of given rat object fits with given parameters
     *
     * @param r rat sighting
     * @return sightingsThatDay
     */
    private boolean onDate(RatSighting r, int month, int year) {

        String date = r.getDate();
        String[]dateArray = date.split("/");
        if (dateArray.length < 3) return false;

        if (Integer.valueOf(dateArray[0]) == month && Integer.valueOf(dateArray[2]) == year) return true;
        return false;
    }

    /**
     * Obtains a list of entries
     * @return
     */
    private ArrayList<Entry> getEntries() {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        int[] dates = SetDateActivity.getDates();
        for (int y = dates[2]; y <= dates[5]; y++) {
            int mStart = 1;
            int mEnd = 12;
            if (y == Integer.valueOf(dates[2])) {
                mStart = Integer.valueOf(dates[1]);
            }
            if (y == Integer.valueOf(dates[5])) {
                mEnd = Integer.valueOf(dates[4]);
            }
            for (int m = mStart; m <= mEnd; m++) {
                entries.add(new Entry(m + (12 * y), getCount(m, y)));
            }
        }
        return entries;
    }

}
