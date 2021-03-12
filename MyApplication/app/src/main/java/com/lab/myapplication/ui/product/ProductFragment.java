package com.lab.myapplication.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.lab.myapplication.ProductActivity;
import com.lab.myapplication.R;
import com.lab.myapplication.sanpham.AnimationUtil;
import com.lab.myapplication.sanpham.Product;
import com.lab.myapplication.sanpham.ProductAdapter;
import com.lab.myapplication.sanpham.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    private RecyclerView rcvProduct;
    private View mView;
    private ProductActivity mainActivity;
    private ProductAdapter productAdapter;
    private AHBottomNavigation ahBottomNavigation;
    private AHBottomNavigationViewPager ahBottomNavigationViewPager;
    private ViewPagerAdapter adapter;

    private View viewEndAnimation;
    private ImageView viewAnimation;

    private int mCountProduct;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_product, container, false);
        //mainActivity = (ProductActivity) getActivity();

        rcvProduct = mView.findViewById(R.id.rcv_product);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcvProduct.setLayoutManager(linearLayoutManager);

        productAdapter = new ProductAdapter();
        productAdapter.setData(getListProduct(), new ProductAdapter.IClickAddToCartListener() {
            @Override
            public void onclickAddToCart(final ImageView imgAddToCart, final Product product) {
                AnimationUtil.translateAnimation(mainActivity.getViewAnimation(), imgAddToCart, mainActivity.getViewEndAnimation(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        product.setAddToCart(true);
                        imgAddToCart.setBackgroundResource(R.drawable.bg_gray_corner_6);
                        productAdapter.notifyDataSetChanged();

                        mainActivity.setCountProductInCart(mainActivity.getCountProduct() + 1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        rcvProduct.setAdapter(productAdapter);

        viewEndAnimation = mView.findViewById(R.id.view_end_animation);
        viewAnimation = mView.findViewById(R.id.view_animation);

        ahBottomNavigation = mView.findViewById(R.id.AHBottomNavigation);
        ahBottomNavigationViewPager = mView.findViewById(R.id.AHBottomNavigationViewPager);

       //adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ahBottomNavigationViewPager.setAdapter(adapter);
        ahBottomNavigationViewPager.setPagingEnabled(true);

        //AHBottomNavigation bottomNavigation = (AHBottomNavigation) mView.findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_product, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_cart, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_notice, R.color.color_tab_3);


        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                ahBottomNavigationViewPager.setCurrentItem(position);
                return true;
            }
        });

        ahBottomNavigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ahBottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return mView;
    }



    private List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));
        list.add(new Product(R.drawable.image, "Product_name", "This is description"));




        return list;
    }

    public View getViewEndAnimation() {
        return viewEndAnimation;
    }

    public ImageView getViewAnimation() {
        return viewAnimation;
    }

//    public void setCountProductInCart (int count){
//        mCountProduct = count;
//        AHNotification notification = new AHNotification.Builder()
//                .setText(String.valueOf(count))
//                .setBackgroundColor(ContextCompat.getColor(ProductActivity.this, R.color.red))
//                .setTextColor(ContextCompat.getColor(ProductActivity.this, R.color.white))
//                .build();
//        ahBottomNavigation.setNotification(notification, 1);
//    }

    public int getCountProduct() {
        return mCountProduct;
    }
}