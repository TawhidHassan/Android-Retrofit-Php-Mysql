package com.example.retrofitphpmysql.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitphpmysql.R;
import com.example.retrofitphpmysql.storgae.SharedPrefManager;

public class HomeFragment extends Fragment {
    private TextView textViewEmail, textViewName, textViewSchool;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewName = view.findViewById(R.id.textViewName);
        textViewSchool = view.findViewById(R.id.textViewSchool);

        textViewEmail.setText(SharedPrefManager.getInstance(getActivity()).getUser().getEmail());
        textViewName.setText(SharedPrefManager.getInstance(getActivity()).getUser().getName());
        textViewSchool.setText(SharedPrefManager.getInstance(getActivity()).getUser().getSchool());
    }
}