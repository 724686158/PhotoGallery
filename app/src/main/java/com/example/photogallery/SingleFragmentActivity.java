package com.example.photogallery;

/**
 * Created by 离子态狍子 on 2016/10/3.
 */

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 离子态狍子 on 2016/9/30.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment ();

    /**
     * 如果不想再使用固定不变的activity_fragment.xml布局，子类可以选择覆盖该方法返回所需布局
     * @return
     */
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;//这个.xml里没有组件
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

}