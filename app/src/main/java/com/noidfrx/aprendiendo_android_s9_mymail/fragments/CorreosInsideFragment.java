package com.noidfrx.aprendiendo_android_s9_mymail.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.noidfrx.aprendiendo_android_s9_mymail.R;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Mail;

public class CorreosInsideFragment extends Fragment {

    private TextView txtSubject, txtMessage, txtSender;
    private LinearLayout llInside;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_correos_inside, container, false);
        txtSubject = v.findViewById(R.id.txtSubject);
        txtSender = v.findViewById(R.id.txtSender);
        txtMessage = v.findViewById(R.id.txtMessage);
        llInside = v.findViewById(R.id.llInside);
        return v;
    }

    public void renderMail(Mail mail){
        llInside.setVisibility(View.VISIBLE);
        txtMessage.setText(mail.getMessage());
        txtSender.setText(mail.getSenderName());
        txtSubject.setText(mail.getSubject());
    }
}