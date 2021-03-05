package com.lab.kiotmpecbk.activity.trangchu.ui.tongquan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TongQuanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TongQuanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tong quan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}