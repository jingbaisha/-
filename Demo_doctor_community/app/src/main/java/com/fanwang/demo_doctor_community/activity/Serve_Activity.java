package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Serve_Adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/29.
 */

public class Serve_Activity extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_servre_moren)
    TextView tvServreMoren;
    @BindView(R.id.tv_servre_xiaoliang)
    TextView tvServreXiaoliang;
    @BindView(R.id.tv_servre_pingjia)
    TextView tvServrePingjia;
    @BindView(R.id.tv_servre_fujin)
    TextView tvServreFujin;
    @BindView(R.id.tv_ssq)
    TextView tvSsq;
    @BindView(R.id.tv_sq)
    TextView tvSq;
    @BindView(R.id.rcv_serve)
    RecyclerView rcvServe;

    private TitleBackFragment titleBackFragment;
    String[] data = {"默认", "销量", "评价", "附近"};
    List<Fragment> mFragmentList = new ArrayList<>();
    ArrayList<CustomTabEntity> list = new ArrayList<>();
    private Serve_Adapter adapter;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serve_activity);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("呼吸内科", "#23b1a5");
        addTitleFragment(titleBackFragment);
        tvServreMoren.setSelected(true);
    }

    @Override
    public void initData() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item));
        rcvServe.addItemDecoration(divider);

        adapter = new Serve_Adapter(this);
        rcvServe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvServe.setAdapter(adapter);
        adapter.GetOnclickItems(new Serve_Adapter.OnclickItem() {
            @Override
            public void SetOnclickItems(int position, View view) {
                intent = new Intent(Serve_Activity.this, Details_a.class);
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.tv_servre_moren, R.id.tv_servre_xiaoliang, R.id.tv_servre_pingjia, R.id.tv_servre_fujin})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_servre_moren:
                initOnclick(1);
                break;
            case R.id.tv_servre_xiaoliang:
                initOnclick(2);
                break;
            case R.id.tv_servre_pingjia:
                initOnclick(3);
                break;
            case R.id.tv_servre_fujin:
                initOnclick(4);
                break;
        }
    }

    private void initOnclick(int i) {
        if (i == 1) {
            tvServreMoren.setSelected(true);
        } else {
            tvServreMoren.setSelected(false);
        }
        if (i == 2) {
            tvServreXiaoliang.setSelected(true);
        } else {
            tvServreXiaoliang.setSelected(false);
        }
        if (i == 3) {
            tvServrePingjia.setSelected(true);
        } else {
            tvServrePingjia.setSelected(false);
        }
        if (i == 4) {
            tvServreFujin.setSelected(true);
        } else {
            tvServreFujin.setSelected(false);
        }

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
    }
}
