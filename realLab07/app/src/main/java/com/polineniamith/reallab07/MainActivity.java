package com.polineniamith.reallab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final Player[] players = new Player[8];
    private final int [] pictures = new int[8];
    private final int [] gifs = new int[8];

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictures[0] = R.drawable.amith;
        pictures[1] = R.drawable.tommy;
        pictures[2] = R.drawable.amith;
        pictures[3] = R.drawable.amith;
        pictures[4] = R.drawable.amith;
        pictures[5] = R.drawable.amith;
        pictures[6] = R.drawable.amith;
        pictures[7] = R.drawable.tommy;

        gifs[0] = R.drawable.frisbee1;
        gifs[1] = R.drawable.universalhealthcare;
        gifs[2] = R.drawable.frisbee1;
        gifs[3] = R.drawable.frisbee1;
        gifs[4] = R.drawable.frisbee1;
        gifs[5] = R.drawable.frisbee1;
        gifs[6] = R.drawable.frisbee1;
        gifs[7] = R.drawable.universalhealthcare;

        players[0] =  Player.newInstance("amith", pictures[0], "#FEC918", gifs[0]);
        players[1] =  Player.newInstance("dev", pictures[1], "#FF0000", gifs[1]);
        players[2] =  Player.newInstance("dylan", pictures[2], "#FF0000", gifs[2]);
        players[3] =  Player.newInstance("mihika", pictures[3], "#FF0000", gifs[3]);
        players[4] =  Player.newInstance("ojas", pictures[4], "#FF0000", gifs[4]);
        players[5] =  Player.newInstance("rahul", pictures[5], "#FF0000", gifs[5]);
        players[6] =  Player.newInstance("satvik", pictures[6], "#FF0000", gifs[6]);
        players[7] =  Player.newInstance("tommy", pictures[7], "#FEC135", gifs[7]);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, players[0]);
        ft.commit();
    }

    public void next(View view){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        index++;
        index %= 8;
        System.out.println(index);
        ft.replace(R.id.frameLayout, players[index]);
        ft.commit();
    }

    public void prev(View view){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        index--;
        if(index == -1){index = 7;}
        System.out.println(index);
        ft.replace(R.id.frameLayout, players[index]);
        ft.commit();
    }
}