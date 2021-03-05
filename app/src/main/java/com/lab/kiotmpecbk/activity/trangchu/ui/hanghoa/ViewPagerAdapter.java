package com.lab.kiotmpecbk.activity.trangchu.ui.hanghoa;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DanhSachSanPhamFragment();
            case 1:
                return new GioHangFragment();
            case 2:
                return new ThanhToanFragment();
            default:
                return new DanhSachSanPhamFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
