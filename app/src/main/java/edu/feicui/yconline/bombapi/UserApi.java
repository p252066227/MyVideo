package edu.feicui.yconline.bombapi;


import edu.feicui.yconline.entity.UserEntity;
import edu.feicui.yconline.result.UserResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface UserApi {

    /**
     * 用户注册
     */
    @POST("1/users")
    Call<UserResult> register(@Body UserEntity userEntity);

    /**
     * 用户登录
     */
    @GET("1/login") Call<UserResult> login(
            @Query("username") String username,
            @Query("password") String password
    );
}
