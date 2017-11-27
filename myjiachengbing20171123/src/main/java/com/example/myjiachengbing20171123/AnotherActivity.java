package com.example.myjiachengbing20171123;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.myjiachengbing20171123.Adapter.ShowAdapter;
import com.example.myjiachengbing20171123.Applictions.Img;
import com.example.myjiachengbing20171123.Bean.Beans;
import com.example.myjiachengbing20171123.OkUtils.OkHttpUtils;
import com.example.myjiachengbing20171123.OkUtils.OnUiCallback;
import com.example.myjiachengbing20171123.Presenter.MyPresenter;
import com.example.myjiachengbing20171123.Utils.Api;
import com.example.myjiachengbing20171123.activity.MainActivity;
import com.example.myjiachengbing20171123.utill.View.Iview;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class AnotherActivity extends BaseActivity<MyPresenter> implements Iview {
    private Banner mBan;
    List<String> list = new ArrayList<>();
    private RecyclerView mRecy;
    //private VideoView videoView;

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressBar mProgressBar;
    private Button start;
    private Button pause;
    private Button bo;
    private VideoView vv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        //初始化 Fresco
        Fresco.initialize(this);
        setContentView(R.layout.activity_another);
        //隐藏标题
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        vv = (VideoView) findViewById(R.id.video_view);
        Uri rawUri = Uri.parse(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/local2/adc.mp4");
        vv.setVideoURI(rawUri);
        vv.start();

        initView();
        okUrlBanner();
        MyPresenter presenter = new MyPresenter(this);
        presenter.loadData();}


    private void initView() {
        mBan = (Banner) findViewById(R.id.ban);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        // videoView= (VideoView) findViewById(R.id.video_view);
        //创建布局管理器
        LinearLayoutManager ll = new LinearLayoutManager(this);
        mRecy.setLayoutManager(ll);

    }

    //Banner轮播
    private void okUrlBanner() {
        OkHttpUtils.getInstance().doGet(Api.BanUrl, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {
                Log.i("1111", "onFailed: "+e);
            }

            @Override
            public void onSuccess(String result) throws IOException {
                Gson gson = new Gson();
                Beans beans = gson.fromJson(result, Beans.class);

                Log.i("2222", "onFailed: "+beans);
                for (int i = 0; i < beans.getData().size(); i++) {
                    list.add(beans.getData().get(i).getImage_url());
                }
                mBan.setImageLoader(new Img());
                mBan.setImages(list);
                mBan.start();
            }
        });
    }

    //请求数据
    @Override
    public void setData(final List<Beans.DataBean> beanList) {
        //创建适配器
        ShowAdapter showAdapter = new ShowAdapter(AnotherActivity.this, beanList);
        mRecy.setAdapter(showAdapter);
        //条目点击
        showAdapter.setmOnItemClickListener(new ShowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(AnotherActivity.this,"点击下载播放",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(AnotherActivity.this,MainActivity.class);
                //intent.putExtra("mp4",beanList.get(position).getVedio_url());
                startActivity(intent);


            }
        });
    }

    @Override
    protected void createpresenter() {

    }
}











