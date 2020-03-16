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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView messageList = findViewById(R.id.messagesList);

        List<MessageRetro> messages = Arrays.asList(new MessageRetro("Blá Blá Blá",1),new MessageRetro("Blá Blá Blá Blá",2));

        MessageAdapter adapter = new MessageAdapter(messages,this,clientId);

        messageList.setAdapter(adapter);

        sendBtt = findViewById(R.id.sendBtt);
        messageField = findViewById(R.id.messageField);

        sendBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ChatService().send(new MessageRetro(messageField.getText().toString(),3));
            }
        });

    }
}
