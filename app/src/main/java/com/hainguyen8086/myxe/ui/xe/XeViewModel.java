package com.hainguyen8086.myxe.ui.xe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public XeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Xe fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}