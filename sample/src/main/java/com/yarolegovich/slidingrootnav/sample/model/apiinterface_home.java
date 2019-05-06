package com.yarolegovich.slidingrootnav.sample.model;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface_home {
    @FormUrlEncoded
    @POST("montag/Galia/Galia_content.php")
    Call<List<contact_home>> getcontacts_first(@Field("category") String category);
   @FormUrlEncoded
    @POST("montag/Galia/Galia_add_category.php")
    Call<ResponseBody> getcontacts(@Field("name") String name, @Field("details") String details, @Field("image") String image,
                                   @Field("address") String address, @Field("categroy") String category, @Field("copon") String copon,
                                   @Field("phone") String phone, @Field("link") String link);
    @FormUrlEncoded
    @POST("montag/Galia/Galia_update_category.php")
    Call<ResponseBody> getcontacts_update(@Field("name") String name, @Field("details") String details, @Field("image") String image,
                                          @Field("address") String address, @Field("categroy") String category, @Field("copon") String copon,
                                          @Field("phone") String phone, @Field("link") String link, @Field("id") int id);

    @GET("montag/Galia/Galia_allcontent.php")
    Call<List<contact_home>> getcontacts_allfirst();
    @FormUrlEncoded
    @POST("montag/Galia/Galia_delete_category.php")
    Call<ResponseBody> delete_category(@Field("id") int id);
}

