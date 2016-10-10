package com.qxg.comproj.retrofit.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Qking on 2016/10/9.
 */

public interface PicService {
    @GET("/pic/get")
    Call<ResponseBody> downloadPic();
}
