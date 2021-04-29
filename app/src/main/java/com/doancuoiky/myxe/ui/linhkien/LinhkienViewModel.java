package com.doancuoiky.myxe.ui.linhkien;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LinhkienViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LinhkienViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Thay linh kien ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}