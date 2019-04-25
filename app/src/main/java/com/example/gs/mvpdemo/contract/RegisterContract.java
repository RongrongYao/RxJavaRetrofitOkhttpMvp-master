package com.example.gs.mvpdemo.contract;

public class RegisterContract {
    public interface RegisterView{
        String getUserName();
        String getPwd();
        void  registerSuccess(String str);
        void registerFail(String failMsg);
    }
    public interface RegisterPresenter{
        void register(String name,String pwd);
    }
}
