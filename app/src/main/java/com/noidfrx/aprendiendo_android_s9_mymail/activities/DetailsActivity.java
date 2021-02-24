package com.noidfrx.aprendiendo_android_s9_mymail.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.noidfrx.aprendiendo_android_s9_mymail.R;
import com.noidfrx.aprendiendo_android_s9_mymail.fragments.CorreosInsideFragment;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Mail;

public class DetailsActivity extends AppCompatActivity {

    private String sender, message, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        sender = getIntent().getStringExtra("sender");
        message = getIntent().getStringExtra("message");
        subject = getIntent().getStringExtra("subject");

        Mail mail = new Mail(subject,message,sender);
        CorreosInsideFragment correosInsideFragment = (CorreosInsideFragment) getSupportFragmentManager().findFragmentById(R.id.correosInsideFragment);
        correosInsideFragment.renderMail(mail);
    }
}