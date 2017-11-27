package com.example.myjiachengbing20171123;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
public abstract class BaseActivity<T extends Ipp> extends AppCompatActivity {

    //定义属性
    T  presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //定义抽象方法
        createpresenter();
    }

    protected abstract void createpresenter();


    //销毁的方法
    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detch();
    }
}



