package com.polineniamith.lab06better;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class basicFragment extends Fragment {

    String title;
    int person;
    ViewPager2 vp2;
    TextView tv;
    ImageView img;
    public static ConstraintLayout background;
    private final String[] characters = {"michle", "dwight", "jim", "pam", "andy"};

    public static basicFragment newInstacnce(ViewPager2 mViewPager, String my_tittle, int character) {
        basicFragment fragment = new basicFragment();
        fragment.vp2 = mViewPager;
        fragment.title = my_tittle;
        fragment.person = character;
        return fragment;
    }
//    public basicFragment(String my_tittle, int character) {
//        title = my_tittle;
//        person = character;
//    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = getActivity().findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, vp2,
                (tab, position) -> tab.setText(characters[position])
        ).attach();

        background = view.findViewById(R.id.background);

        tv = view.findViewById(R.id.basicTextView);
        tv.setText(title);
        img = view.findViewById(R.id.basicimageView);
        img.setImageResource(person);
    }
}