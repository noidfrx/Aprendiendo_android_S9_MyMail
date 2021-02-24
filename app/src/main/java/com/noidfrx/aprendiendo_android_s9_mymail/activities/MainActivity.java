package com.noidfrx.aprendiendo_android_s9_mymail.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.noidfrx.aprendiendo_android_s9_mymail.R;
import com.noidfrx.aprendiendo_android_s9_mymail.fragments.CorreosFragment;
import com.noidfrx.aprendiendo_android_s9_mymail.fragments.CorreosInsideFragment;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Mail;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Util;

public class MainActivity extends AppCompatActivity implements CorreosFragment.OnFragmentInteractionListener {

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

        //  Si no se encuentra el fragment correosInside multipanel = false
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.correosInsideFragment) != null);

    }

    //INTERFAZ DE CORREOS FRAGMENT
    @Override
    //CUANDO SE HACE CLICK EN UN CORREO
    public void onListClick(Mail mail) {

        //  Si TABLET renderizamos correo inside y renderizamos mail que nos pasan
        if(isMultiPanel){
            CorreosInsideFragment correosInsideFragment = (CorreosInsideFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.correosInsideFragment);
            correosInsideFragment.renderMail(mail);
        }
        //  Si CELULAR abrimos nueva actividad pasando los datos
        else{
            Intent i = new Intent(MainActivity.this, DetailsActivity.class);
            i.putExtra("subject", mail.getSubject());
            i.putExtra("sender", mail.getSenderName());
            i.putExtra("message", mail.getMessage());
            startActivity(i);
        }
    }
}