package com.example.gs.mvpdemo.activity;

import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.gs.mvpdemo.R;
import com.example.gs.mvpdemo.base.BaseActivity;
import com.example.gs.mvpdemo.contract.RegisterContract;
import com.example.gs.mvpdemo.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterPresenter>implements RegisterContract.RegisterView {
    @BindView(R.id.register_email)//注册账号
    EditText registeremail;
    @BindView(R.id.register_password)//注册密码
    EditText registerpassword;
    @BindView(R.id.btn_register)
    AppCompatButton btnregister;


    @Override
    protected  RegisterPresenter loadPresenter(){
        return new RegisterPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnregister.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        ButterKnife.bind (this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void otherViewClick(View view) {
        mPresenter.register(getUserName(),getPwd());

    }

    @Override
    public String getUserName() {
        return registeremail.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return registerpassword.getText().toString().trim();
    }

    @Override
    public void registerSuccess(String str) {
        toast(str);

    }

    @Override

    public void registerFail(String failMsg) {
        toast(failMsg);

    }
    public boolean checkNull(){
        boolean isNull=false;
        if(TextUtils.isEmpty(getUserName())){
            registeremail.setText("注册账号不能为空");
            isNull=true;
        } else if(TextUtils.isEmpty(getPwd())){
            registerpassword.setText("设置密码不能为空");
            isNull=true;
        }
        return  isNull;
    }

}
