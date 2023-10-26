package com.example.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import androidx.core.content.ContextCompat;
import com.example.resistorcalculator.RectanglesView;


public class MainActivity extends AppCompatActivity {
    public List<ResistorColor> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.custom_spinner);
        Spinner spinner2 = findViewById(R.id.custom_spinner2);
        Spinner spinner3 = findViewById(R.id.custom_spinner3);
        Spinner spinner4 = findViewById(R.id.custom_spinner4);


        colors.add(new ResistorColor("None",0,0,0.2f));
        colors.add(new ResistorColor("Black",0,1,0));
        colors.add(new ResistorColor("Brown",1,10,0.01f));
        colors.add(new ResistorColor("Red",2,100,0.02f));
        colors.add(new ResistorColor("Orange",3,1000,0));
        colors.add(new ResistorColor("Yellow",4,10000,0));
        colors.add(new ResistorColor("Green",5,100000,0.005f));
        colors.add(new ResistorColor("Blue",6,1000000,0.0025f));
        colors.add(new ResistorColor("Violet",7,10000000,0.001f));
        colors.add(new ResistorColor("Grey",8,100000000,0.0005f));
        colors.add(new ResistorColor("White",9,1000000000,0));
        colors.add(new ResistorColor("Gold",0,0.1f,0.05f));
        colors.add(new ResistorColor("Silver",0,0.01f,0.1f));

        List<String> bandColorNames = new ArrayList<>();
        List<String> multiplierColorNames = new ArrayList<>();
        List<String> toleranceColorNames = new ArrayList<>();

        for (int i = 0; i < colors.size(); i++){
            if(colors.get(i).getColor() != "Gold" && colors.get(i).getColor() != "Silver"){
                bandColorNames.add(colors.get(i).getColor());
            }

            multiplierColorNames.add(colors.get(i).getColor());

            if(colors.get(i).getTolerance() !=0){
                toleranceColorNames.add(colors.get(i).getColor());
            }
        }

        CustomBandSpinnerAdapter bandAdapter = new CustomBandSpinnerAdapter(this,bandColorNames);
        CustomMultiplierSpinnerAdapter multiplierAdapter = new CustomMultiplierSpinnerAdapter(this,multiplierColorNames);
        CustomToleranceSpinnerAdapter toleranceAdapter = new CustomToleranceSpinnerAdapter(this,toleranceColorNames);
        spinner.setAdapter(bandAdapter);
        spinner2.setAdapter(bandAdapter);
        spinner3.setAdapter(multiplierAdapter);
        spinner4.setAdapter(toleranceAdapter);
        Context context = MainActivity.this;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int[] colorResources = {
                        R.color.none,
                        R.color.black,
                        R.color.brown,
                        R.color.red,
                        R.color.orange,
                        R.color.yellow,
                        R.color.green,
                        R.color.blue,
                        R.color.violet,
                        R.color.grey,
                        R.color.white,
                };

                RectanglesView band1 = findViewById(R.id.band1);
                band1.setSelectedColor(ContextCompat.getColor(context, colorResources[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected here
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int[] colorResources = {
                        R.color.none,
                        R.color.black,
                        R.color.brown,
                        R.color.red,
                        R.color.orange,
                        R.color.yellow,
                        R.color.green,
                        R.color.blue,
                        R.color.violet,
                        R.color.grey,
                        R.color.white,
                };

                RectanglesView band1 = findViewById(R.id.band2);
                band1.setSelectedColor(ContextCompat.getColor(context, colorResources[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected here
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int[] colorResources = {
                        R.color.none,
                        R.color.black,
                        R.color.brown,
                        R.color.red,
                        R.color.orange,
                        R.color.yellow,
                        R.color.green,
                        R.color.blue,
                        R.color.violet,
                        R.color.grey,
                        R.color.white,
                        R.color.gold,
                        R.color.silver,
                };

                RectanglesView band1 = findViewById(R.id.multiplier);
                band1.setSelectedColor(ContextCompat.getColor(context, colorResources[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected here
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int[] colorResources = {
                        R.color.none,
                        R.color.brown,
                        R.color.red,
                        R.color.green,
                        R.color.blue,
                        R.color.violet,
                        R.color.grey,
                        R.color.gold,
                        R.color.silver,
                };

                RectanglesView band1 = findViewById(R.id.tolerance);
                band1.setSelectedColor(ContextCompat.getColor(context, colorResources[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected here
            }
        });
    }
    public void doCalculation(View view){
        Spinner spinner = findViewById(R.id.custom_spinner);
        Spinner spinner2 = findViewById(R.id.custom_spinner2);
        Spinner spinner3 = findViewById(R.id.custom_spinner3);
        Spinner spinner4 = findViewById(R.id.custom_spinner4);
        String band1 = spinner.getSelectedItem().toString();
        int band1Value = 0;
        String band2 = spinner2.getSelectedItem().toString();
        int band2Value = 0;
        String multiplier = spinner3.getSelectedItem().toString();
        float multiplierValue = 0.00f;
        String tolerance = spinner4.getSelectedItem().toString();
        float toleranceValue = 0.00f;
        TextView res = findViewById(R.id.calculation);

        for (int i = 0; i < colors.size(); i++){
            if(band1 == colors.get(i).getColor()){
                band1Value = colors.get(i).getBandValue();
            } else if (band2 == colors.get(i).getColor()) {
                band2Value = colors.get(i).getBandValue();
            }else if (multiplier == colors.get(i).getColor()) {
                multiplierValue = colors.get(i).getMultiplierValue();
            }else if (tolerance == colors.get(i).getColor()) {
                toleranceValue = colors.get(i).getTolerance();
            }
        }
        int num = ((band1Value * 10) + band2Value);
        BigDecimal bigDecimal = new BigDecimal(num * multiplierValue);
        res.setText(String.format("%.2fΩ ±%.2f%%", bigDecimal, toleranceValue * 100 / 1));
    }
    public void clr(View v){
        TextView res = findViewById(R.id.calculation);
        res.setText("");
        Spinner spinner = findViewById(R.id.custom_spinner);
        Spinner spinner2 = findViewById(R.id.custom_spinner2);
        Spinner spinner3 = findViewById(R.id.custom_spinner3);
        Spinner spinner4 = findViewById(R.id.custom_spinner4);
        spinner.setSelection(0);
        spinner2.setSelection(0);
        spinner3.setSelection(0);
        spinner4.setSelection(0);
    }
}