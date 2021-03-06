package com.example.chat_retrofit.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chat_retrofit.R;
import com.example.chat_retrofit.adapter.MessageAdapter;
import com.example.chat_retrofit.app.ChatApplication;
import com.example.chat_retrofit.callback.ReceiveCallback;
import com.example.chat_retrofit.callback.SendCallback;
import com.example.chat_retrofit.model.MessageRetro;
import com.example.chat_retrofit.service.ChatService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private int clientId = 1;
    private EditText messageField;
    private Button sendBtt;

    private ListView messageList;
    private List<MessageRetro> messages;
    private ChatService chatService;

    public static final String BASE_URL = "hhtp://localhost:8080/";
    public static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageList = findViewById(R.id.messagesList);
        sendBtt = findViewById(R.id.sendBtt);
        messageField = findViewById(R.id.messageField);

//        messages = Arrays.asList(new MessageRetro("Blá Blá Blá",1),new MessageRetro("Blá Blá Blá Blá",2));

        putOnList(new MessageRetro("Teste Teste",3));

        ChatApplication app = (ChatApplication) getApplication();
        chatService = app.getChatService();

//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        chatService = retrofit.create(ChatService.class);
//        chatService = getChatService(retrofit);
        receiveMessages();

//        sendBtt.setOnClickListener(v -> chatService.send(new MessageRetro(messageField.getText().toString(),clientId)).enqueue(new SendCallback()));

//        sendBtt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               chatService.send(new MessageRetro(messageField.getText().toString(),clientId)).enqueue(new SendCallback());
//
//            }
//        });

    }

    public void putOnList(MessageRetro message) {
        messages.add(message);

        MessageAdapter adapter = new MessageAdapter(messages,this,clientId);
        messageList.setAdapter(adapter);
    }

    public void receiveMessages() {
        Call<MessageRetro> call = chatService.receive();
        call.enqueue(new ReceiveCallback(this));
    }

    public void clickSend(View view) {

        String messageToSend = messageField.getText().toString();
        MessageRetro convertedToMessage = new MessageRetro(messageToSend,clientId);

        SendCallback sendCallback = new SendCallback();

        chatService.send(convertedToMessage).enqueue(sendCallback);
    }

//    public ChatService getChatService(Retrofit retrofit) {
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ChatService chatServiceL = retrofit.create(ChatService.class);
//        return chatServiceL;
//    }

}

