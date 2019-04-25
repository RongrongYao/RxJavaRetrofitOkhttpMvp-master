package com.example.gs.mvpdemo.model;

import android.support.annotation.NonNull;

import com.example.gs.mvpdemo.ProApplication;
import com.example.gs.mvpdemo.base.BaseModel;
import com.example.gs.mvpdemo.bean.RegisterBean;
import com.example.gs.mvpdemo.exception.ApiException;
import com.example.gs.mvpdemo.subscriber.CommonSubscriber;
import com.example.gs.mvpdemo.transformer.CommonTransformer;

public class RegisterModel extends BaseModel {
    private boolean isRegister = false;

    public boolean register(@NonNull String username, @NonNull String pwd, @NonNull final InfoHint
            infoHint) {

        if (infoHint == null)
            throw new RuntimeException("InfoHint不能为空");

        httpService.register(username, pwd)
                .compose(new CommonTransformer<RegisterBean>())
                .subscribe(new CommonSubscriber<RegisterBean>(ProApplication.getmContext()) {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        isRegister = true;
                        infoHint.successInfo(RegisterBean.getToken());
                    }

                    @Override
                    protected void onError(ApiException e) {
                        super.onError(e);
                        isRegister= false;
                        infoHint.failInfo(e.message);
                    }
                });
        return isRegister;

    }
    public interface InfoHint{
        void successInfo(String str);
        void failInfo(String str);
    }
}
