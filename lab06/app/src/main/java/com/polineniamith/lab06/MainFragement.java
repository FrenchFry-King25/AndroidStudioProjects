package com.polineniamith.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragement extends Fragment {
    Button mB;
    ViewPager2 vp2;

    public static MainFragement newInstacnce(ViewPager2 mViewPager) {
        MainFragement fragment = new MainFragement();
        fragment.vp2 = mViewPager;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);\
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, vp2, (tab, position) -> tab.setText("I am " + (position + 1))).attach();
        mB = view.findViewById(R.id.b1);
        mB.setText("Click " + vp2.getCurrentItem());
        mB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "toasting" + vp2.getCurrentItem(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
