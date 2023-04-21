package com.polineniamith.lab06better;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private final String[] characters = {"michael", "dwight", "jim", "pam", "andy"};
    private int [] people = new int[characters.length];
    ViewPager2 vp2;
    RecyclerView.Adapter mFSA;
    public static MediaPlayer mp;
    public static boolean countswipes = false;
    private static Context context;
    public static TabLayout background;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp2 = findViewById(R.id.basicViewPager);
        mFSA = new SampleAdapter(this);
        vp2.setAdapter(mFSA);
        vp2.setPageTransformer(new CubeOutTransformer());
        context = getApplicationContext();
        mp = MediaPlayer.create(context, R.raw.thatswhatshesaid);
        mp.setVolume((float) 0.9, (float) .9);
        background = findViewById(R.id.tabs);
        background.setBackgroundColor(Color.argb(0, 200, 200, 200));

        people[0] = R.drawable.michael;
        people[1] = R.drawable.dwight;
        people[2] = R.drawable.jim;
        people[3] = R.drawable.pam;
        people[4] = R.drawable.andy;

//        TabLayout tabs = findViewById(R.id.tabs);
//        new TabLayoutMediator(tabs, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(characters[position]);
////                tab.setIcon(people[position]);
//            }
//        }).attach();
    }

    class SampleAdapter extends FragmentStateAdapter {

        public SampleAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return basicFragment.newInstacnce(vp2, characters[position], people[position]);
        }

        @Override
        public int getItemCount() {
            return characters.length;
        }
    }


    public static Context getAppContext() {
        return MainActivity.context;
    }
}