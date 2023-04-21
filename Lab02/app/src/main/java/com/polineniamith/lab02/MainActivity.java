package com.polineniamith.lab02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayText;
    TextView foodDisplay;
    TextView toppingDisplay;
    TextView beverageDisplay;
    Button click;
    String [] foodsList;
    String [] toppingsList;
    String [] beveragesList;
    EditText name;
    int count = 0;
    CheckBox toppingsCheck, beveragesCheck;
    ConstraintLayout bg;

    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.displayText);
        foodDisplay = findViewById(R.id.foodDisplay);
        toppingDisplay = findViewById(R.id.toppingDisplay);
        beverageDisplay = findViewById(R.id.beverageDisplay);
        click = findViewById(R.id.clickme);
        foodsList = getResources().getStringArray(R.array.food);
        toppingsList = getResources().getStringArray(R.array.toppings);
        beveragesList = getResources().getStringArray(R.array.beverages);
        toppingsCheck = findViewById(R.id.toppings);
        beveragesCheck = findViewById(R.id.beverages);
        name = findViewById(R.id.name);
        bg = findViewById(R.id.bg);
        bg.setBackgroundColor(Color.argb(255, 240, 234, 125));

        click.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                System.out.println("clicked");
                String top = "";
                if(toppingsCheck.isChecked()) {top = toppingsList[(int)(Math.random() * toppingsList.length)];}

                String foo = foodsList[(int)(Math.random() * foodsList.length)];
                String bev = "with a ";
                if(beveragesCheck.isChecked()) {bev += beveragesList[(int)(Math.random() * beveragesList.length)];}
                else {bev= "";}
                foodDisplay.setText(getString(R.string.fullDisplay, top, foo, bev));
                toppingDisplay.setText("");
                beverageDisplay.setText("");

                displayText.setText(getString(R.string.displayName, name.getText().toString()));

//                foodDisplay.setText(getString(R.string.foodDisplay, foodsList[(int)(Math.random() * foodsList.length)]));
//                try {
//                    Thread.sleep(500);
//                    if(toppingsCheck.isChecked()) {
//                        toppingDisplay.setText(getString(R.string.toppingDisplay, toppingsList[(int)(Math.random() * toppingsList.length)]));
//                    } else {
//                        toppingDisplay.setText("");
//                    }
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                try {
//                    Thread.sleep(500);
//                    if (beveragesCheck.isChecked()) {
//                        beverageDisplay.setText(getString(R.string.beverageDisplay, beveragesList[(int)(Math.random() * beveragesList.length)]));
//                    } else {
//                        beverageDisplay.setText("");
//                    }
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

            }
        });
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onRestart() {
        super.onRestart();
        bg.setBackgroundColor(Color.argb(255, 236, 190, 237));
    }


}