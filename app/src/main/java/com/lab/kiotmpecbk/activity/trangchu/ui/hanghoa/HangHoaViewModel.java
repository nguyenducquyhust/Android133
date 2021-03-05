package com.lab.kiotmpecbk.activity.trangchu.ui.hanghoa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HangHoaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HangHoaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is hang hoa fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}