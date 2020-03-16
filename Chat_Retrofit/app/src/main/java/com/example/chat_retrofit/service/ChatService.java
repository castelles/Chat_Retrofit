package com.example.chat_retrofit.service;

import com.example.chat_retrofit.model.MessageRetro;

import org.json.JSONStringer;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatService {

    public void send(final MessageRetro message) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                String text = message.getText();

                try {
                    HttpURLConnection url = (HttpURLConnection) new URL("http://172.100.10.193:8080/polling").openConnection();
                    url.setRequestMethod("POST");
                    url.setRequestProperty("content-type","application/json");

                    JSONStringer json = new JSONStringer().object()
                            .key("text")
                            .value(text)
                            .key("id")
                            .value(message.getId())
                            .endObject();

                    OutputStream out = url.getOutputStream();
                    PrintStream ps = new PrintStream(out);

                    ps.println(json.toString());

                    url.connect();
                    url.getInputStream();

                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }


        }).start();

    }
}
