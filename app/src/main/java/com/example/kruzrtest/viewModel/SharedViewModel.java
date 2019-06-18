package com.example.kruzrtest.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> mList = new MutableLiveData<>();

    public LiveData<String> getText() {
        return mList;
    }

    public void setText(String input) {
        mList.setValue(input);
    }
}
