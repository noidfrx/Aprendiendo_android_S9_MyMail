package com.noidfrx.aprendiendo_android_s9_mymail.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.noidfrx.aprendiendo_android_s9_mymail.R;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Util;

public class MainActivity extends AppCompatActivity {

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Llenamos isMultiPanel
        setMultiPanel();

    }

    //  Preguntamos si están los 2 fragments renderizados
    private void setMultiPanel() {
        /*isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.))*/
    }
}