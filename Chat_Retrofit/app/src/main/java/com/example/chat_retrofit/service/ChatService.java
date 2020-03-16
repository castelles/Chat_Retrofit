package com.example.chat_retrofit.service;

import com.example.chat_retrofit.model.MessageRetro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ChatService {

    @POST("polling")
    Call<MessageRetro> send(@Body MessageRetro message);

    @GET("polling")
    Call<MessageRetro> receive();

}
