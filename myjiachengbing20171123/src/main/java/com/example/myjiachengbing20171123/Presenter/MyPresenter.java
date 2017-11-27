package com.example.myjiachengbing20171123.Presenter;


import android.util.Log;

import com.example.myjiachengbing20171123.Bean.Beans;
import com.example.myjiachengbing20171123.Ipp;
import com.example.myjiachengbing20171123.Model.IModel;
import com.example.myjiachengbing20171123.Model.MyModel;
import com.example.myjiachengbing20171123.utill.View.Iview;

import java.lang.ref.SoftReference;
import java.util.List;

import rx.Observer;


/**
 * Created by tangxiaoying on 2017/11/13.
 */

public class MyPresenter implements Ipp<Iview> {
    IModel model;
    Iview view;

    SoftReference<Iview> softReference;//软引用
    public MyPresenter(Iview view) {
         this.view = view;
         model=new MyModel();

        attch(view);
    }

    public void loadData(){
        model.setObSerVer(new Observer<Beans>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("///", "onError: "+e);
            }

            @Override
            public void onNext(Beans  beans ) {
                List<Beans.DataBean> data = beans.getData();
               //   Log.i("/////", "onNext: "+data.size());
             softReference.get().setData(data);

              //  view.setData(data);

            }
        });
    }



    @Override
    public void attch(Iview view) {
        softReference=new SoftReference<Iview>(view);
    }

    @Override
    public void detch() {
        softReference.clear();
    }
}
