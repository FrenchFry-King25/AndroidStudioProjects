package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SymptomsChecker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_checker);

        Button submitBtn = findViewById(R.id.button4);
        submitBtn.setOnClickListener(v -> {
            CheckBox throatBox = findViewById(R.id.throatBox);
            boolean throat = throatBox.isChecked();
            CheckBox noseBox = findViewById(R.id.noseBox);
            boolean nose = noseBox.isChecked();
            CheckBox eyeBox = findViewById(R.id.eyeBox);
            boolean eye = eyeBox.isChecked();
            CheckBox sneezeBox = findViewById(R.id.sneezeBox);
            boolean sneeze = sneezeBox.isChecked();
            CheckBox skinBox = findViewById(R.id.skinBox);
            boolean skin = skinBox.isChecked();
            CheckBox fatigueBox = findViewById(R.id.fatigueBox);
            boolean fatigue = fatigueBox.isChecked();
            CheckBox breatheBox = findViewById(R.id.breatheBox);
            boolean breathe = breatheBox.isChecked();
            CheckBox coughBox = findViewById(R.id.coughBox);
            boolean cough = coughBox.isChecked();
            CheckBox gastrointestinalBox = findViewById(R.id.gastrointestinalBox);
            boolean gastrointestinal = gastrointestinalBox.isChecked();
            CheckBox headacheBox = findViewById(R.id.headacheBox);
            boolean headache = headacheBox.isChecked();
            CheckBox checkBox33 = findViewById(R.id.checkBox33);
            boolean lymph_tonsils = checkBox33.isChecked();
            CheckBox feverBox = findViewById(R.id.feverBox);
            boolean fever = feverBox.isChecked();
            CheckBox faintBox = findViewById(R.id.faintBox);
            boolean faint = faintBox.isChecked();

            boolean[] checkList = new boolean[13];
            checkList[0] = throat;
            checkList[1] = nose;
            checkList[2] = eye;
            checkList[3] = sneeze;
            checkList[4] = skin;
            checkList[5] = fatigue;
            checkList[6] = breathe;
            checkList[7] = cough;
            checkList[8] = gastrointestinal;
            checkList[9] = headache;
            checkList[10] = lymph_tonsils;
            checkList[11] = fever;
            checkList[12] = faint;


            EditText stomach = findViewById(R.id.stomachIn);
            int stomachPain = Integer.parseInt(stomach.getText().toString());
            if (stomachPain > 10) {
                stomachPain = 10;
            } else if (stomachPain < 0) {
                stomachPain = 0;
            }
            EditText chest = findViewById(R.id.chestIn);
            int chestPain = Integer.parseInt(chest.getText().toString());
            if (chestPain > 10) {
                chestPain = 10;
            } else if (chestPain < 0) {
                chestPain = 0;
            }

            int[] severity = new int[2];
            severity[0] = chestPain;
            severity[1] = stomachPain;

            String diagnosis = "Asthma";
            Intent next = new Intent(getApplicationContext(), Diagnosis.class);
            next.putExtra("com.example.myapplication.DIAGNOSIS", diagnosis);
            next.putExtra("com.example.myapplication.SEVERITY", severity);
            next.putExtra("com.example.myapplication.SYMPTOMS", checkList);
            startActivity(next);
        });
    }
}