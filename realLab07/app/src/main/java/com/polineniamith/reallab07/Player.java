package com.polineniamith.reallab07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifImageView;

public class Player extends Fragment {
    View view;

    public static Player newInstance(String name, int picture, String color, int gif) {
        Player player = new Player();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("picture", picture);
        args.putString("color", color);
        args.putInt("gif", gif);

        player.setArguments(args);
        return player;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflate xml layout file
        return inflater.inflate(R.layout.player,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        String name = getArguments().getString("name", "");
        int picture = getArguments().getInt("picture", 0);
        String color = getArguments().getString("color", "");
        int gif = getArguments().getInt("gif", 0);

        TextView nameView = view.findViewById(R.id.name);
        nameView.setText(name);
        ImageView pictureView = view.findViewById(R.id.person);
        pictureView.setImageResource(picture);
        ConstraintLayout bg = view.findViewById(R.id.background);
        bg.setBackgroundColor(Color.parseColor(color));
        GifImageView gifView = view.findViewById(R.id.gif);
        gifView.setImageResource(gif);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
