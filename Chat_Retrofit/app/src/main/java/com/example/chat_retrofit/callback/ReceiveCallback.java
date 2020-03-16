package com.example.chat_retrofit.callback;

import com.example.chat_retrofit.activity.MainActivity;
import com.example.chat_retrofit.model.MessageRetro;

import retrofit2.Call;
import retrofit2.Response;

public class ReceiveCallback implements retrofit2.Callback<MessageRetro>
{

    MainActivity activity;

    public ReceiveCallback(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(Call<MessageRetro> call, Response<MessageRetro> response) {
        if (response.isSuccessful()) {
            MessageRetro message = response.body();
//                activity.putOnList();
        }
    }

    @Override
    public void onFailure(Call<MessageRetro> call, Throwable t) {
        activity.receiveMessages();
    }
}
