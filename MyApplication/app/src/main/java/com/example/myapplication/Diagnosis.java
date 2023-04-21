package com.example.myapplication;
import android.telephony.SmsManager;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Diagnosis extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        if (getIntent().hasExtra("com.example.myapplication.DIAGNOSIS")) {
            String diagnosisIn = getIntent().getExtras().getString("com.example.myapplication.DIAGNOSIS");
            boolean[] checkList = getIntent().getExtras().getBooleanArray("com.example.myapplication.SYMPTOMS");
            int[] severity = getIntent().getExtras().getIntArray("com.example.myapplication.SEVERITY");

            String output = "Hi, here are my symptoms: ";
            String[] simps = new String[13];
            simps[0] = "rough throat";
            simps[1] = "stuffy nose";
            simps[2] = "eye irritation";
            simps[3] = "sneezes";
            simps[4] = "skin irritation";
            simps[5] = "fatigue";
            simps[6] = "breathing problems";
            simps[7] = "cough";
            simps[8] = "gastrointestinal problems";
            simps[9] = "headaches";
            simps[10] = "swollen lymph nodes and tonsils";
            simps[11] = "fever";
            simps[12] = "fainting and lightheadedness";

            int c = 0;
            for (int x = 0; x < checkList.length; x++) {
                if (checkList[x]) {
                    if(c > 0) {
                        output = output + ", " + simps[x];
                    }
                    else
                    {
                        output = output + simps[x];
                        c++;
                    }
                }
            }
            output = output + ".";

            TextView severe = (TextView) findViewById(R.id.severText);
            if(severity[0] > 8 || severity[1] > 8)
            {
                severe.setText("Your condition is serious: you need to call 911 or go to the ER");
            }
            else if (severity[0] > 1 || severity[1] > 1|| checkList[6])
            {
                severe.setText("Your condition is moderate: schedule an appointment with your doctor below");
            }
            else
            {
                TextView doc = (TextView) findViewById(R.id.message);
                doc.setText("");
                severe.setText("Your condition is mild: if your symptoms get worse, schedule an appointment with your doctor here:");
            }



            String diag = "My Diagnosis is: " + diagnosisIn;
            TextView diagn = (TextView) findViewById(R.id.diagnosisText);
            diagn.setText(diag);
            TextView message = (TextView) findViewById(R.id.messageText);
            message.setText(output);

            String msg = output;
            EditText txtPhoneNo = (EditText) findViewById(R.id.editTextPhone);
            String phoneNumber = txtPhoneNo.getText().toString();
            Button btnSendSMS = (Button) findViewById(R.id.sendBtn);
            btnSendSMS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ContextCompat.checkSelfPermission(Diagnosis.this
                            , Manifest.permission.SEND_SMS)
                            != PackageManager.PERMISSION_GRANTED) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage("+15403261686", null, "TEST", null, null);
                    }
                }
            });
        }
    }
}

