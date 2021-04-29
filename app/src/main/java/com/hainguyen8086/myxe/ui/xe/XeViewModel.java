package com.hainguyen8086.myxe.ui.xe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public XeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("danh sách xe");
    }

    public LiveData<String> getText() {
        return mText;
    }
}