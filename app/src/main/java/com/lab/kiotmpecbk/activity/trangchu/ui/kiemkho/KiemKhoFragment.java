package com.lab.kiotmpecbk.activity.trangchu.ui.kiemkho;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lab.kiotmpecbk.R;
import com.lab.kiotmpecbk.activity.trangchu.ui.tongquan.TongQuanViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KiemKhoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KiemKhoFragment extends Fragment {

    private KiemKhoViewModel kiemKhoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        kiemKhoViewModel =
                ViewModelProviders.of(this).get(KiemKhoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kiem_kho, container, false);
        final TextView textView = root.findViewById(R.id.text_kiemkho);
        kiemKhoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}