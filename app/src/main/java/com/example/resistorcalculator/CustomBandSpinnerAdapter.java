package com.example.resistorcalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class CustomBandSpinnerAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> items;

    public CustomBandSpinnerAdapter(Context context, List<String> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
        View view = convertView != null ? convertView : LayoutInflater.from(context).inflate(R.layout.custom_spinner_item, parent, false);
        TextView textView = view.findViewById(R.id.spinner_item_text);
        textView.setText(items.get(position));
        // Set text color based on the item name
        if (position < colorResources.length) {
            int colorResId = colorResources[position];
            textView.setBackgroundColor(ContextCompat.getColor(context, colorResId));
            if (ContextCompat.getColor(context, colorResId) == ContextCompat.getColor(context, R.color.white) || ContextCompat.getColor(context, colorResId) == ContextCompat.getColor(context, R.color.none)) {
                textView.setTextColor(ContextCompat.getColor(context, R.color.black));
            }
        }

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    public int getColor(int i) {
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
        return colorResources[i];
    }
}
