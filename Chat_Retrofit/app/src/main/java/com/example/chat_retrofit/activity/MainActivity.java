package com.example.chat_retrofit.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chat_retrofit.R;
import com.example.chat_retrofit.adapter.MessageAdapter;
import com.example.chat_retrofit.model.MessageRetro;
import com.example.chat_retrofit.service.ChatService;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int clientId = 1;
    private EditText messageField;
    private Button sendBtt;

    private ListView messageList;
    private List<MessageRetro> messages;
    private ChatService chatService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageList = findViewById(R.id.messagesList);

        messages = Arrays.asList(new MessageRetro("Blá Blá Blá",1),new MessageRetro("Blá Blá Blá Blá",2));

        MessageAdapter adapter = new MessageAdapter(messages,this,clientId);

        messageList.setAdapter(adapter);

        sendBtt = findViewById(R.id.sendBtt);
        messageField = findViewById(R.id.messageField);

        chatService = new ChatService(this);
        chatService.receive();

        sendBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               chatService.send(new MessageRetro(messageField.getText().toString(),3));
            }
        });

    }

    public void putOnList(MessageRetro message) {
        messages.add(message);

        MessageAdapter adapter = new MessageAdapter(messages,this,clientId);
        messageList.setAdapter(adapter);

        chatService.receive();
    }
}
