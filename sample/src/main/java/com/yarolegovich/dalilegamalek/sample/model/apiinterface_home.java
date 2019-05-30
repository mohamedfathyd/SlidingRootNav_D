package com.yarolegovich.dalilegamalek.sample.model;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface_home {

    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_user.php")
    Call<ResponseBody> getcontacts(@Field("name") String name,@Field("password") String password, @Field("address") String address, @Field("phone") String phone,
                                   @Field("date") String date, @Field("email") String email, @Field("image") String image
    );
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_login.php")
    Call<List<contact_home>>getcontacts_login( @Field("phonee") String phonee,@Field("password")String password);

    @GET("montag/dallejamalk/Gmalek_first_category.php")
    Call<List<content_category>> getcontacts_allfirst();
    @GET("montag/dallejamalk/Gmalek_annonce.php")
    Call<List<contact_annonce>> getcontacts_annonce();
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_second_category.php")
    Call<List<contact_order>> getcontacts_second(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_fillter.php")
    Call<List<contact_order>> getcontacts_filtter(@Field("id") int id,@Field("city")String city,@Field("from")int from,@Field("to")int to);

    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_sendpoint.php")
    Call<ResponseBody> getcontacts_send(@Field("id_send") int id_send,@Field("id_receive") int id_receive , @Field("points")int points);

    @FormUrlEncoded
    @POST("montag/dallejamalk/Gmalek_Like.php")
    Call<ResponseBody> getcontacts_like(@Field("user_id") int user_id,@Field("annonce_id") int annonce_id );

}

