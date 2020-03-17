package com.example.chat_retrofit.app;

import android.app.Application;

import com.example.chat_retrofit.activity.MainActivity;
import com.example.chat_retrofit.service.ChatService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatApplication extends Application
{

    public ChatService getChatService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChatService chatService = retrofit.create(ChatService.class);
        return chatService;
    }
}
