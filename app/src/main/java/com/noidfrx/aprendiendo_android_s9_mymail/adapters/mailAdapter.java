package com.noidfrx.aprendiendo_android_s9_mymail.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noidfrx.aprendiendo_android_s9_mymail.R;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Mail;

import java.util.ArrayList;

public class mailAdapter extends RecyclerView.Adapter<mailAdapter.ViewHolder> {

    private Activity activity;
    private int layout;
    private ArrayList<Mail> listaDeMail;
    private OnMailClickListener listener;

    public mailAdapter(Activity activity, int layout, ArrayList<Mail> listaDeMail, OnMailClickListener listener) {
        this.activity = activity;
        this.layout = layout;
        this.listaDeMail = listaDeMail;
        this.listener = listener;
    }

    @NonNull
    @Override
    public mailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull mailAdapter.ViewHolder holder, int position) {
        holder.bind(listaDeMail.get(position), listener, activity);
    }

    @Override
    public int getItemCount() {
        return listaDeMail.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvSubject, tvMessage, tvImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvImage = itemView.findViewById(R.id.tvImage);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }


        //  Enlazamos vista con datos
        public void bind(Mail mail, OnMailClickListener listener, Activity activity) {
            tvSubject.setText(mail.getSubject());
            tvMessage.setText(mail.getMessage());
            tvImage.getBackground().setColorFilter(Color.parseColor("#"+mail.getColor()), PorterDuff.Mode.SRC);
            tvImage.setText(obtenerPrimeraLetra(mail));

            //  Lo que se hace al presionar un item se define en activity/fragment
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMenuClick(mail, getAdapterPosition());
                }
            });
        }

        private String obtenerPrimeraLetra(Mail mail) {
            String fullWord = mail.getSenderName();
            String firstLetter = fullWord.substring(0,1);
            return firstLetter;
        }
    }

    public interface OnMailClickListener{
        void onMenuClick(Mail itemMail, int position);
    }

}
