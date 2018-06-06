package com.fanwang.demo_doctor_community.fragment.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.My_Order;
import com.fanwang.demo_doctor_community.activity.My_serve_bao;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chaoyue on 2018/5/18.
 */

public class My_Fragment extends Popuplace_Fragment {

    Unbinder unbinder;
    @BindView(R.id.iv_home_saoyisao)
    ImageView ivHomeSaoyisao;
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.my_serve)
    LinearLayout myServe;
    @BindView(R.id.my_chiyao_tixing)
    LinearLayout myChiyaoTixing;
    @BindView(R.id.my_complaint)
    LinearLayout myComplaint;
    @BindView(R.id.my_problem)
    LinearLayout myProblem;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }

    @OnClick({R.id.my_indent_rl, R.id.my_serve_bao})
    public void OnItemsOnclick(View view) {
        switch (view.getId()) {
            case R.id.my_indent_rl:
                intent = new Intent(getContext(), My_Order.class);
                startActivity(intent);
                break;
            case R.id.my_serve_bao:
                intent = new Intent(getContext(), My_serve_bao.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
