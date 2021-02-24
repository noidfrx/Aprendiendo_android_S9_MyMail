package com.noidfrx.aprendiendo_android_s9_mymail.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noidfrx.aprendiendo_android_s9_mymail.R;
import com.noidfrx.aprendiendo_android_s9_mymail.adapters.mailAdapter;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Mail;
import com.noidfrx.aprendiendo_android_s9_mymail.model.Util;

public class CorreosFragment extends Fragment {

    private RecyclerView rvCorreos;
    private RecyclerView.Adapter mAdadpter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_correos, container, false);
        rvCorreos = v.findViewById(R.id.rvCorreos);

        mLayoutManager = new LinearLayoutManager(getContext());
        mAdadpter = new mailAdapter(getActivity(), R.layout.item_list_mail, Util.getDummyData(), new mailAdapter.OnMailClickListener() {
            @Override
            public void onMenuClick(Mail itemMail, int position) {
                mListener.onListClick(itemMail);
            }
        });
        rvCorreos.setLayoutManager(mLayoutManager);
        rvCorreos.setAdapter(mAdadpter);
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()+" must implement OnFragmentInteractionListener");
        }
    }

    //Por temas de memoria
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener{
        void onListClick(Mail mail);
    }
}