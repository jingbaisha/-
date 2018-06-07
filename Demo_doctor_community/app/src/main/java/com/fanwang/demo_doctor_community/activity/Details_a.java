package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Details_Adaper_b;
import com.fanwang.demo_doctor_community.adapter.Details_Adpter_a;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/5/30.
 */

public class Details_a extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.star_doctor)
    StarBar starDoctor;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button_dai)
    Button buttonDai;
    @BindView(R.id.rlv_details)
    RecyclerView rlvDetails;
    @BindView(R.id.rcy_serve_a)
    RecyclerView rcyServeA;
    @BindView(R.id.lv_details)
    RecyclerView lvDetails;
    private TitleBackFragment titleBackFragment;
    private Details_Adpter_a adpter;
    private Details_Adaper_b adaper_b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_a);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "详情", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        //第一部分
        adpter = new Details_Adpter_a(this);
        rlvDetails.setLayoutManager(new GridLayoutManager(this,4));
        rlvDetails.setAdapter(adpter);

        //第二部分
        adaper_b = new Details_Adaper_b(this);
        rcyServeA.setAdapter(adaper_b);
        rcyServeA.setLayoutManager(new GridLayoutManager(this,1));
    }
}
