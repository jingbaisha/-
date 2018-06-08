package com.fanwang.demo_doctor_community.fragment.serve;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chaoyue on 2018/5/18.
 */

public class Serve_Fragment extends Fragment {

    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.login_btn)
    Button loginBtn;

    Unbinder unbinder;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.lin_lay_search)
    RelativeLayout linLaySearch;
    @BindView(R.id.rb_one)
    RadioButton rbOne;
    @BindView(R.id.rb_two)
    RadioButton rbTwo;
    @BindView(R.id.rb_three)
    RadioButton rbThree;
    private FragmentTransaction fragmentTransaction;
    private FragmentTransaction fragmentTransaction1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.serve_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        rbOne.setChecked(true);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction1 = this.fragmentTransaction.replace(R.id.fl_right, new Serve_right_items());
        fragmentTransaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.rb_one,R.id.rb_two,R.id.rb_three,R.id.login_btn})
    public void OnItemsOnclick(View view){
        switch (view.getId()){
            case R.id.rb_one:
            case R.id.rb_two:
            case R.id.rb_three:
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction1 = this.fragmentTransaction.replace(R.id.fl_right, new Serve_right_items());
                fragmentTransaction.commit();
                break;

            case R.id.login_btn:
                MaterialDialog dialog = new MaterialDialog.Builder(getContext())
                        .customView(R.layout.dialog_a, false)
                        .build();
                dialog.show();
                break;
        }
    }
}
