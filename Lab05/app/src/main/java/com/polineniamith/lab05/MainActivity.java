package com.polineniamith.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int countonCreatelifetime, countonCreatesession = 0;
    int countonStartlifetime, countonStartsession = 0;
    int countonResumelifetime, countonResumesession = 0;
    int countonPauselifetime, countonPausesession = 0;
    int countonStoplifetime, countonStopsession = 0;
    int countonRestartlifetime, countonRestartsession = 0;
    int countonDestroylifetime, countonDestroysession = 0;

    TextView onCreatelifetime;
    TextView onStartlifetime;
    TextView onResumelifetime;
    TextView onPauselifetime;
    TextView onStoplifetime;
    TextView onRestartlifetime;
    TextView onDestorylifetime;
    TextView onCreatesession;
    TextView onStartsession;
    TextView onResumesession;
    TextView onPausesession;
    TextView onStopsession;
    TextView onRestartsession;
    TextView onDestorysession;

    Button clearLifetime;
    Button clearSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Values", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setInit();

        countonCreatelifetime++;
        countonCreatesession++;
        editor.putInt("onCreatelifetime", countonCreatelifetime);
        editor.putInt("onCreatesession", countonCreatesession);
        editor.apply();
        printValues();
        onCreatelifetime.setText(getString(R.string.onCreatelifetime, (countonCreatelifetime + 1)));
        onCreatesession.setText(getString(R.string.onCreatesession, countonCreatesession));

        clearLifetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countonCreatelifetime = 0;
                countonStartlifetime = 0;
                countonResumelifetime = 0;
                countonPauselifetime = 0;
                countonStoplifetime = 0;
                countonRestartlifetime = 0;
                countonDestroylifetime = 0;
                editor.putInt("onCreatelifetime", countonCreatelifetime);
                editor.putInt("onStartlifetime", countonStartlifetime);
                editor.putInt("onResumelifetime", countonResumelifetime);
                editor.putInt("onPauselifetime", countonPauselifetime);
                editor.putInt("onStoplifetime", countonStoplifetime);
                editor.putInt("onRestartlifetime", countonRestartlifetime);
                editor.putInt("onDestroylifetime", countonDestroylifetime);
                editor.apply();
                onCreatelifetime.setText(getString(R.string.onCreatelifetime, countonCreatelifetime));
                onStartlifetime.setText(getString(R.string.onStartlifetime, countonStartlifetime));
                onResumelifetime.setText(getString(R.string.onResumelifetime, countonResumelifetime));
                onPauselifetime.setText(getString(R.string.onPauselifetime, countonPauselifetime));
                onStoplifetime.setText(getString(R.string.onStoplifetime, countonStoplifetime));
                onRestartlifetime.setText(getString(R.string.onRestartlifetime, countonRestartlifetime));
                onDestorylifetime.setText(getString(R.string.onDestorylifetime, countonDestroylifetime));
            }
        });

        clearSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countonCreatesession = 0;
                countonStartsession = 0;
                countonResumesession = 0;
                countonPausesession = 0;
                countonStopsession = 0;
                countonRestartsession = 0;
                countonDestroysession = 0;
                editor.putInt("onCreatesession", countonCreatesession);
                editor.putInt("onStartsession", countonStartsession);
                editor.putInt("onResumesession", countonResumesession);
                editor.putInt("onPausesession", countonPausesession);
                editor.putInt("onStopsession", countonStopsession);
                editor.putInt("onRestartsession", countonRestartsession);
                editor.putInt("onDestroysession", countonDestroysession);
                editor.apply();
                onCreatesession.setText(getString(R.string.onCreatesession, countonCreatesession));
                onStartsession.setText(getString(R.string.onStartsession, countonStartsession));
                onResumesession.setText(getString(R.string.onResumesession, countonResumesession));
                onPausesession.setText(getString(R.string.onPausesession, countonPausesession));
                onStopsession.setText(getString(R.string.onStopsession, countonStopsession));
                onRestartsession.setText(getString(R.string.onRestartsession, countonRestartsession));
                onDestorysession.setText(getString(R.string.onDestorysession, countonDestroysession));
            }
        });
    }

    private void setInit() {
        countonCreatelifetime = sharedPreferences.getInt("onCreatelifetime", 0);
        countonStartlifetime = sharedPreferences.getInt("onStartlifetime", 0);
        countonResumelifetime = sharedPreferences.getInt("onResumelifetime", 0);
        countonPauselifetime = sharedPreferences.getInt("onPauselifetime", 0);
        countonStoplifetime = sharedPreferences.getInt("onStoplifetime", 0);
        countonRestartlifetime = sharedPreferences.getInt("onRestartlifetime", 0);
        countonDestroylifetime = sharedPreferences.getInt("onDestroylifetime", 0);
        countonCreatesession = sharedPreferences.getInt("onCreatesession", 0);
        countonStartsession = sharedPreferences.getInt("onStartsession", 0);
        countonResumesession = sharedPreferences.getInt("onResumesession", 0);
        countonPausesession = sharedPreferences.getInt("onPausesession", 0);
        countonStopsession = sharedPreferences.getInt("onStopsession", 0);
        countonRestartsession = sharedPreferences.getInt("onRestartsession", 0);
        countonDestroysession = sharedPreferences.getInt("onDestroysession", 0);

        onCreatelifetime = findViewById(R.id.onCreatelifetime);
        onStartlifetime = findViewById(R.id.onStartlifetime);
        onResumelifetime = findViewById(R.id.onResumelifetime);
        onPauselifetime = findViewById(R.id.onPauselifetime);
        onStoplifetime = findViewById(R.id.onStoplifetime);
        onRestartlifetime = findViewById(R.id.onRestartlifetime);
        onDestorylifetime = findViewById(R.id.onDestorylifetime);
        onCreatesession = findViewById(R.id.onCreatesession);
        onStartsession = findViewById(R.id.onStartsession);
        onResumesession = findViewById(R.id.onResumesession);
        onPausesession = findViewById(R.id.onPausesession);
        onStopsession = findViewById(R.id.onStopsession);
        onRestartsession = findViewById(R.id.onRestartsession);
        onDestorysession = findViewById(R.id.onDestorysession);

        clearLifetime = findViewById(R.id.buttonlifetime);
        clearSession = findViewById(R.id.buttonsession);

        onCreatelifetime.setText(getString(R.string.onCreatelifetime, countonCreatelifetime));
        onStartlifetime.setText(getString(R.string.onStartlifetime, countonStartlifetime));
        onResumelifetime.setText(getString(R.string.onResumelifetime, countonResumelifetime));
        onPauselifetime.setText(getString(R.string.onPauselifetime, countonPauselifetime));
        onStoplifetime.setText(getString(R.string.onStoplifetime, countonStoplifetime));
        onRestartlifetime.setText(getString(R.string.onRestartlifetime, countonRestartlifetime));
        onDestorylifetime.setText(getString(R.string.onDestorylifetime, countonDestroylifetime));
        onCreatesession.setText(getString(R.string.onCreatesession, countonCreatesession));
        onStartsession.setText(getString(R.string.onStartsession, countonStartsession));
        onResumesession.setText(getString(R.string.onResumesession, countonResumesession));
        onPausesession.setText(getString(R.string.onPausesession, countonPausesession));
        onStopsession.setText(getString(R.string.onStopsession, countonStopsession));
        onRestartsession.setText(getString(R.string.onRestartsession, countonRestartsession));
        onDestorysession.setText(getString(R.string.onDestorysession, countonDestroysession));
    }

    private void printValues() {
        System.out.println("Values onCreate:" + countonCreatelifetime);
        System.out.println("Values onStart:" + countonStartlifetime);
        System.out.println("Values onResume:" + countonResumelifetime);
        System.out.println("Values onPause:" + countonPauselifetime);
        System.out.println("Values onStop:" + countonStoplifetime);
        System.out.println("Values onRestart:" + countonRestartlifetime);
        System.out.println("Values onDestroy:" + countonDestroylifetime);
        System.out.println("Values ==========================");
    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStartlifetime++;
        countonStartsession++;
        editor.putInt("onStartlifetime", countonStartlifetime);
        editor.putInt("onStartsession", countonStartsession);
        editor.apply();
        printValues();
        onStartlifetime.setText(getString(R.string.onStartlifetime, countonStartlifetime));
        onStartsession.setText(getString(R.string.onStartsession, countonStartsession));
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResumelifetime++;
        countonResumesession++;
        editor.putInt("onResumelifetime", countonResumelifetime);
        editor.putInt("onResumesession", countonResumesession);
        editor.apply();
        printValues();
        onResumelifetime.setText(getString(R.string.onResumelifetime, countonResumelifetime));
        onResumesession.setText(getString(R.string.onResumesession, countonResumesession));
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPauselifetime++;
        countonPausesession++;
        editor.putInt("onPauselifetime", countonPauselifetime);
        editor.putInt("onPausesession", countonPausesession);
        editor.apply();
        printValues();
        onPauselifetime.setText(getString(R.string.onPauselifetime, countonPauselifetime));
        onPausesession.setText(getString(R.string.onPausesession, countonPausesession));
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStoplifetime++;
        countonStopsession++;
        editor.putInt("onStoplifetime", countonStoplifetime);
        editor.putInt("onStopsession", countonStopsession);
        editor.apply();
        printValues();
        onStoplifetime.setText(getString(R.string.onStoplifetime, countonStoplifetime));
        onStopsession.setText(getString(R.string.onStopsession, countonStopsession));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestartlifetime++;
        countonRestartsession++;
        editor.putInt("onRestartlifetime", countonRestartlifetime);
        editor.putInt("onRestartsession", countonRestartsession);
        editor.apply();
        printValues();
        onRestartlifetime.setText(getString(R.string.onRestartlifetime, countonRestartlifetime));
        onRestartsession.setText(getString(R.string.onRestartsession, countonRestartsession));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroylifetime++;
        countonDestroysession++;
        editor.putInt("onDestroylifetime", countonDestroylifetime);
        editor.putInt("onDestroysession", countonDestroysession);
        onDestorylifetime.setText(getString(R.string.onDestorylifetime, countonDestroylifetime));
        onDestorysession.setText(getString(R.string.onDestorysession, countonDestroysession));

        countonCreatesession = 0;
        countonStartsession = 0;
        countonResumesession = 0;
        countonPausesession = 0;
        countonStopsession = 0;
        countonRestartsession = 0;
        countonDestroysession = 0;
        editor.putInt("onCreatesession", countonCreatesession);
        editor.putInt("onStartsession", countonStartsession);
        editor.putInt("onResumesession", countonResumesession);
        editor.putInt("onPausesession", countonPausesession);
        editor.putInt("onStopsession", countonStopsession);
        editor.putInt("onRestartsession", countonRestartsession);
        editor.putInt("onDestroysession", countonDestroysession);
        editor.apply();
        printValues();
    }


}