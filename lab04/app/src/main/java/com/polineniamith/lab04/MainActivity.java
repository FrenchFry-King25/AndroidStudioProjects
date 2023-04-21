package com.polineniamith.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    int layouts[];
    int c = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layouts = new int[]{R.layout.l1, R.layout.l2, R.layout.l3, R.layout.l4, R.layout.l5, R.layout.l6, R.layout.l7};


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            c = (++c)%layouts.length;
            setContentView(layouts[c]);
            System.out.println(c);
            System.out.println(layouts[c]);
        }

        return true;
    }
}