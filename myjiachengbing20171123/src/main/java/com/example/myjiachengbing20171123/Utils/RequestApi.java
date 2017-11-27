package com.example.myjiachengbing20171123.Utils;


import com.example.myjiachengbing20171123.Bean.Beans;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yfeng on 2017/11/16.
 */

public interface RequestApi {
    public static final String BASE_URL = "http://result.eolinker.com/";

    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Observable<Beans> getData();

//    @Streaming
//    @POST("{fileName}")
//    Call<ResponseBody> downloadFile(@Path("fileName") String fileName, @Header("Range") String range);
//
//    @Streaming
//    @POST("{fileName}")
//    Call<ResponseBody> getFileLenght(@Path("fileName") String fileName);
}
