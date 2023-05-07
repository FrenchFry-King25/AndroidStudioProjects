package com.polineniamith.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textMain;
    FragmentA fragA;
    DrawView dv;
    Button button;
    public static MediaPlayer mp;
    private static Context context;
    boolean fast = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dv = findViewById(R.id.drawView);
        textMain = findViewById(R.id.main_text);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        button = findViewById(R.id.reverseButton);
        //ft.replace(R.id.frag_holder, new );
        context = getApplicationContext();
        mp = MediaPlayer.create(context, R.raw.bounce);
        mp.setVolume((float) 0.9, (float) .9);

    }

    public void update_main(View view) {
        textMain.setText("Hello123");
        ((Button)view).setText("YO I CLICKED");
        fragA.update("LETS GO i updated");
    }

    public void reverseY(View view) {
        if(fast) {
            dv.faster();
            fast = !fast;
            button.setText("slower");
        } else {
            dv.slower();
            fast = !fast;
            button.setText("faster");
        }
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }}