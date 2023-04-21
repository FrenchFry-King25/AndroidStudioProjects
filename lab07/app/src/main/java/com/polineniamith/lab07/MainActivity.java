package com.polineniamith.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textMain;
    FragmentA fragA;
    DrawView dv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dv = findViewById(R.id.drawView);
        textMain = findViewById(R.id.main_text);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.replace(R.id.frag_holder, new );

    }

    public void update_main(View view) {
        textMain.setText("Hello123");
        ((Button)view).setText("YO I CLICKED");
        fragA.update("LETS GO i updated");
    }

    public void reverseY(View view) {
        dv.setDy(dv.getDy() * -1);
    }
}