package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

/**
 * Created by edison on 2018/5/23.
 */

public class Register_Activity extends Populace_Activity{

    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "注册", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
}
