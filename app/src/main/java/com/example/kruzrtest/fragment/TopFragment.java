package com.example.kruzrtest.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kruzrtest.R;
import com.example.kruzrtest.viewModel.SharedViewModel;


public class TopFragment extends Fragment {
    View view;
    TextView fName;
    TextView fGender;
    TextView fEmail;
    Button fSubmit;
    private SharedViewModel viewModel;
    private String name,gender,email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.topfrag, container, false);
        fName = view.findViewById(R.id.name);
        fGender = view.findViewById(R.id.gender);
        fEmail = view.findViewById(R.id.email);
        fSubmit = view.findViewById(R.id.submit);
        fSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = fName.getText().toString();
                gender = fGender.getText().toString();
                email = fEmail.getText().toString();
                if(name.matches("") || gender.matches("") || email.matches("")){
                    Toast.makeText(getActivity(), R.string.error_edittext, Toast.LENGTH_LONG).show();
                }else{
                    viewModel.setText(fName.getText().toString() + "#" + fGender.getText().toString() + "#" + fEmail.getText().toString());
                    Toast.makeText(getActivity(), R.string.submitted, Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }
}
