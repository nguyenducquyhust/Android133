package com.lab.kiotmpecbk.activity.trangchu.ui.hanghoa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.lab.kiotmpecbk.R;
import com.lab.kiotmpecbk.activity.trangchu.ui.tongquan.TongQuanViewModel;

public class HangHoaFragment extends Fragment {

    private HangHoaViewModel hangHoaViewModel;

    private AHBottomNavigation ahBottomNavigation;

    private AHBottomNavigationViewPager ahBottomNavigationViewPager;

    private ViewPagerAdapter viewPagerAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        hangHoaViewModel =
                ViewModelProviders.of(this).get(HangHoaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hanghoa, container, false);
        final TextView textView = root.findViewById(R.id.text_hanghoa);
        hangHoaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}