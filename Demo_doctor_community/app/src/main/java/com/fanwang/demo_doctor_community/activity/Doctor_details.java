package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;
import com.fanwang.demo_doctor_community.custom.XCRoundImageView;
import com.fanwang.demo_doctor_community.fragment.Basic_Fragment;
import com.fanwang.demo_doctor_community.fragment.My_message;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/5/23.
 */

public class Doctor_details extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.view_one)
    View viewOne;
    @BindView(R.id.xri)
    XCRoundImageView xri;
    @BindView(R.id.tv_pingfeng)
    TextView tvPingfeng;
    @BindView(R.id.fengshu)
    TextView fengshu;
    @BindView(R.id.star_doctor)
    StarBar starDoctor;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.doctor_vp)
    ViewPager doctorVp;
    private TitleBackFragment titleBackFragment;
    @BindView(R.id.tl_doctor)
    TabLayout mTab;
    private String[] data = {"基本信息", "个人简历"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_details);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("详情", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        starDoctor.setStarMark(3.6f);
        addTab(mTab);
    }

    private void addTab(TabLayout mTab) {
        for (int i = 0; i < data.length; i++) {
            TabLayout.Tab tab = mTab.newTab().setText(data[i]);
            tab.setText(data[i]);
            mTab.addTab(tab);
        }
        doctorVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
           @Override
           public Fragment getItem(int position) {
               switch (position){
                   case 0:
                       return new Basic_Fragment();
                   default:
                       return new My_message();
               }
           }

           @Override
           public int getCount() {
               return 2;
           }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 1:
                        return getString(R.string.mymessage);
                        default:
                            return getString(R.string.jibenxinxi);
                }
            }
        });
        mTab.setupWithViewPager(doctorVp);
    }

}
