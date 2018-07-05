package com.example.dell.quarterhour.model.untils;

import com.example.dell.quarterhour.bean.AdvertisingBean;
import com.example.dell.quarterhour.bean.ChangeBean;
import com.example.dell.quarterhour.bean.CollectBean;
import com.example.dell.quarterhour.bean.FavoriteBean;
import com.example.dell.quarterhour.bean.GrBean;
import com.example.dell.quarterhour.bean.Hot1Bean;
import com.example.dell.quarterhour.bean.LoginBean;
import com.example.dell.quarterhour.bean.RecommendBean;
import com.example.dell.quarterhour.bean.TextBean;
import com.example.dell.quarterhour.bean.VCRBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by nyj on 2018/5/26.
 */

public interface RetrofitApi {

    @GET("quarter/getAd")
    Observable<AdvertisingBean> getAdvertising();
    @GET("quarter/getHotVideos")
    Observable<RecommendBean> getRecommendBean(@Query("page") int page, @Query("source") String source, @Query("appVersion") String appVersion,@Query("token")String token);
    @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile")String mobile,@Query("password")String password);
    @GET("quarter/resetPass")
    Observable<ChangeBean> getchange(@Query("uid")String uid,@Query("oldPassword")String oldPassword,@Query("newPassword")String newPassword);
    //上传头像
    @POST("file/upload")
    @Multipart
    Observable<TextBean> uploadFile(@Query("uid") String uid, @Part MultipartBody.Part file, @Query("token")String token);
    //个人中心
    @GET("user/getUserInfo")
    Observable<GrBean> getBean(@Query("uid")String uid);
    //关注用户列表
    @GET("quarter/getFollowUsers")
    Observable<CollectBean> getcollect(@Query("uid")String uid,@Query("token")String token, @Query("source") String source, @Query("appVersion") String appVersion);
    @GET("quarter/getHotVideos")
    Observable<Hot1Bean> gethot1(@Query("token")String token, @Query("source") String source, @Query("appVersion") String appVersion, @Query("page") int page);
    //收藏作品
    @GET("quarter/getHotVideos")
    Observable<FavoriteBean> getfavorite(@Query("uid")String uid,@Query("wid")String wid,@Query("token")String token, @Query("source") String source, @Query("appVersion") String appVersion);
    //发布视频作品
    @POST("quarter/publishVideo")
    @Multipart
    Observable<VCRBean> getVCR(@Query("uid") String uid, @Part MultipartBody.Part videoFile, @Part MultipartBody.Part coverFile, @Query("token")String token, @Query("source") String source, @Query("appVersion") String appVersion, @Query("latitude") String latitude, @Query("longitude") String longitude);
}
