package com.example.resistorcalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RectanglesView extends View {
    private Paint paint = new Paint();
    private int selectedColor = Color.RED;

    public RectanglesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(selectedColor);
        canvas.drawRect(50, 70, 200, 290, paint);
        // Add more rectangles as needed
    }

    public void setSelectedColor(int color) {
        selectedColor = color;
        invalidate(); // Redraw the view
    }
}