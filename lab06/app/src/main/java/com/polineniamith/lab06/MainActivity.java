package com.polineniamith.lab06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp2;
    RecyclerView.Adapter mMayFragmentStateAdapter;
    int numItems = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp2 = findViewById(R.id.container);
        mMayFragmentStateAdapter = new MyFragmentStateAdapter(this);
        vp2.setAdapter(mMayFragmentStateAdapter);

    }

    private class MyFragmentStateAdapter extends FragmentStateAdapter {
        public MyFragmentStateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return MainFragement.newInstacnce(vp2);
        }

        @Override
        public int getItemCount() {
            return numItems;
        }
    }
}