package com.example.chat_retrofit.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chat_retrofit.R;
import com.example.chat_retrofit.model.MessageRetro;

import java.util.List;

public class MessageAdapter extends BaseAdapter {

    private List<MessageRetro> messages;
    private Activity activity;
    private int clientId;

    public MessageAdapter(List<MessageRetro> messages, Activity activity,int clientId) {
        this.messages = messages;
        this.activity = activity;
        this.clientId = clientId;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public MessageRetro getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View line = activity.getLayoutInflater().inflate(R.layout.message,parent,false);
        TextView text = line.findViewById(R.id.tvText);

        MessageRetro message = getItem(position);

        if (clientId != message.getId()) {
            line.setBackgroundColor(Color.CYAN);
        }

        text.setText(message.getText());

        return line;
    }
}
