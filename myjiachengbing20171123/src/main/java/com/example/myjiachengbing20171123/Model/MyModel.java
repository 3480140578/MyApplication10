package com.example.myjiachengbing20171123.Model;


import com.example.myjiachengbing20171123.Utils.RequestApi;
import com.example.myjiachengbing20171123.Utils.RetrofitManager;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tangxiaoying on 2017/11/13.
 */

public class MyModel implements IModel{
    @Override
    public void setObSerVer(Observer obSerVer) {
        OkHttpClient okclient = new OkHttpClient.Builder().build();
        RetrofitManager.getInstance(RequestApi.BASE_URL,okclient)
                .setCreate(RequestApi.class)
                .getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(obSerVer);

    }

}
