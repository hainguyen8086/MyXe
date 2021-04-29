package com.doancuoiky.myxe.ui.xang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XangViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public XangViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đổ xăng");
    }

    public LiveData<String> getText() {
        return mText;
    }
}