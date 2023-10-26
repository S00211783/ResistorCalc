package com.example.resistorcalculator;

import android.graphics.Color;

import java.util.List;

import kotlinx.coroutines.channels.ActorKt;

public class ResistorColor {
    private String color;
    private int bandValue;
    private float multiplierValue;
    private float tolerance;

    public ResistorColor(String color, int bandValue, float multiplierValue, float tolerance){
        this.color = color;
        this.bandValue = bandValue;
        this.multiplierValue = multiplierValue;
        this.tolerance = tolerance;
    }

    public String getColor() {
        return this.color;
    }

    public int getBandValue() {
        return this.bandValue;
    }

    public float getMultiplierValue(){
        return  this.multiplierValue;
    }

    public float getTolerance() {
        return this.tolerance;
    }
}
