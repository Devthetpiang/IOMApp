package com.xavey.proto.api;

import com.xavey.proto.api.model.Auth;
import com.xavey.proto.api.model.User;
import com.xavey.proto.api.model.json.FormDoc;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.mime.TypedFile;

/**
 *
 * Created by tinmaungaye on 30.03.16.
 */
public interface ApiInterface {

    @POST("/authenticate/")
    void postAuthToken(@Body Auth auth,
                       Callback<User> result);

    @POST("/collections/data/")
    void postDoc(
            @Header("x-access-token")String authorization,
            @Body FormDoc doc,
                       Callback<Object> obj);

}
