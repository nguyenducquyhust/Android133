package com.lab.kiotmpecbk.activity.trangchu.ui.kiemkho;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KiemKhoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KiemKhoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is kiem kho fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
