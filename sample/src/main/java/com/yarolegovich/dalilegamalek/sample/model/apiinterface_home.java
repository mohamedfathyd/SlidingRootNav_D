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
    @POST("Gmalek_user.php")
    Call<ResponseBody> getcontacts(@Field("name") String name,@Field("password") String password, @Field("address") String address, @Field("phone") String phone,
                                   @Field("date") String date, @Field("email") String email, @Field("image") String image
                                   );
 @FormUrlEncoded
 @POST("Gmalek_login.php")
 Call<List<contact_home>>getcontacts_login( @Field("phonee") String phonee,@Field("password")String password);

    @GET("Gmalek_first_category.php")
    Call<List<content_category>> getcontacts_allfirst();
 @GET("Gmalek_annonce.php")
 Call<List<content_category>> getcontacts_annonce();
    @FormUrlEncoded
    @POST("Gmalek_first_category.php")
    Call<ResponseBody> getcontacts_second(@Field("id") int id);
}

