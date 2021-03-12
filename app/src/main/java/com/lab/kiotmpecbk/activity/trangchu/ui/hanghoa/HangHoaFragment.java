package com.lab.kiotmpecbk.activity.trangchu.ui.hanghoa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.lab.kiotmpecbk.R;
import com.lab.kiotmpecbk.activity.trangchu.ui.hanghoa.banhang.ViewPagerAdapter;
import com.lab.kiotmpecbk.activity.trangchu.ui.tongquan.TongQuanViewModel;

public class HangHoaFragment extends Fragment {

    private HangHoaViewModel hangHoaViewModel;

    private AHBottomNavigation ahBottomNavigation;
    private AHBottomNavigationViewPager ahBottomNavigationViewPager;
    private ViewPagerAdapter adapter;

    private View viewEndAnimation;
    private ImageView viewAnimation;

    private int mCountProduct;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        hangHoaViewModel =
                ViewModelProviders.of(this).get(HangHoaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hanghoa, container, false);

        return root;
    }




}