package com.example.gs.mvpdemo.presenter;

import com.example.gs.mvpdemo.activity.RegisterActivity;
import com.example.gs.mvpdemo.base.BasePresenter;
import com.example.gs.mvpdemo.contract.RegisterContract;
import com.example.gs.mvpdemo.model.RegisterModel;
import com.example.gs.mvpdemo.mvp.IModel;
import com.example.gs.mvpdemo.utils.LogUtils;

import java.util.HashMap;

public class RegisterPresenter extends BasePresenter<RegisterActivity> implements RegisterContract.RegisterPresenter {
    public void register(String name,String pwd){
            if (!getIView().checkNull()) {
                ((RegisterModel) getiModelMap().get("register")).register(name, pwd, new RegisterModel.InfoHint(){
                    @Override
                    public void successInfo(String str) {
                        getIView().registerSuccess(str);  //成功
                    }

                    @Override
                    public void failInfo(String str) {
                        LogUtils.e("RegisterPresenter.failInfo", str);

                        getIView().registerFail(str);  //失败
                    }
                });
            }
        }
    public HashMap<String, IModel> getiModelMap() {
        return loadModelMap(new RegisterModel());
    }
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        HashMap<String, IModel> map = new HashMap<>();
        map.put("register", models[0]);
        return map;
    }
}

