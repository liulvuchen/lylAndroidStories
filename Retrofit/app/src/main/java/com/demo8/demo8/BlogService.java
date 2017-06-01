package com.demo8.demo8;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * describe 接口定义
 * authors liuyaolin
 * createTime 2017/5/31 16:57
 */

public interface BlogService {
    @POST("user/checkUserExist")
    Call<String> getBlog(@Query("loginName") String name);

    @POST("user/checkUserExist")
    Call<String> getBlogMap( @QueryMap Map<String, String> map);


}
