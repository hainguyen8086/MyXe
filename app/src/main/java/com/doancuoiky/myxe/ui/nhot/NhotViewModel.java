package com.doancuoiky.myxe.ui.nhot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NhotViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NhotViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Thay nhớt");
    }

    public LiveData<String> getText() {
        return mText;
    }
}