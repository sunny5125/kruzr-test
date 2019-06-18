package com.example.kruzrtest.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kruzrtest.dataModel.CardData;
import com.example.kruzrtest.R;
import com.example.kruzrtest.viewModel.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

public class BottomFragment extends Fragment {
    public BottomFragRecyclerAdapter mAdapter;
    public List<CardData> listdata = new ArrayList<>();
    RecyclerView mRecyclerView;
    View view;
    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottomfrag, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new BottomFragRecyclerAdapter(listdata);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                String[] sArray = s.split("#");
                CardData cardDa = new CardData(sArray[0], sArray[1], sArray[2]);
                listdata.add(cardDa);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    public class BottomFragCardViewHolder extends RecyclerView.ViewHolder {

        TextView cName;
        TextView cGender;
        TextView cEmail;

        public BottomFragCardViewHolder(@NonNull View itemView) {
            super(itemView);
            cName = itemView.findViewById(R.id.cName);
            cGender = itemView.findViewById(R.id.cGender);
            cEmail = itemView.findViewById(R.id.cEmail);
        }
    }


    public class BottomFragRecyclerAdapter extends RecyclerView.Adapter<BottomFragCardViewHolder> {
        private List<CardData> list;

        public BottomFragRecyclerAdapter(List<CardData> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public BottomFragCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cardforrecycler, viewGroup, false);

            return new BottomFragCardViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(BottomFragCardViewHolder viewHolder, int i) {
            CardData data = list.get(i);
            viewHolder.cName.setText(data.getName());
            viewHolder.cGender.setText(data.getGender());
            viewHolder.cEmail.setText(data.getEmail());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
