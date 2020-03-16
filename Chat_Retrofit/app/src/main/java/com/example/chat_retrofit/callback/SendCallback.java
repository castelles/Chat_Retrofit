package com.example.chat_retrofit.callback;

import com.example.chat_retrofit.model.MessageRetro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendCallback implements Callback<MessageRetro>
{
    @Override
    public void onResponse(Call<MessageRetro> call, Response<MessageRetro> response) {

    }

    @Override
    public void onFailure(Call<MessageRetro> call, Throwable t) {

    }
}
