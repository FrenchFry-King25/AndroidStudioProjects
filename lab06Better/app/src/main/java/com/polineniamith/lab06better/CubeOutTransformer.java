package com.polineniamith.lab06better;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.polineniamith.lab06better.MainActivity;

public class CubeOutTransformer implements ViewPager2.PageTransformer {
//https://www.loginworks.com/blogs/how-to-make-awesome-transition-effects-using-pagetransformer-in-android/

    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setPivotX( position < 0f ? page.getWidth() : 0f );
        page.setPivotY( page.getHeight() * 0.5f );
        page.setRotationY( 90f * position );
//        if (MainActivity.countswipes) {
//            MainActivity.mp.stop();
//            MainActivity.mp.release();
//        }
        if(MainActivity.countswipes) {
            MainActivity.mp.stop();
            MainActivity.mp.release();
            MainActivity.mp = MediaPlayer.create(MainActivity.getAppContext(), R.raw.nogodnopleaseno);
            MainActivity.mp.setVolume((float) 0.3, (float) 0.3);
        } else {
            MainActivity.mp.stop();
            MainActivity.mp.release();
            MainActivity.mp = MediaPlayer.create(MainActivity.getAppContext(), R.raw.thatswhatshesaid);
            MainActivity.mp.setVolume((float) 0.9, (float) 0.9);
        }
        MainActivity.countswipes = !MainActivity.countswipes;
        MainActivity.background.setBackgroundColor(Color.argb(0, 200, 200, 200));
        MainActivity.mp.start();


    }
}