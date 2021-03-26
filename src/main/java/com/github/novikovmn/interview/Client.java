package com.github.novikovmn.interview;

import com.github.novikovmn.interview.client.HttpClient;
import com.github.novikovmn.interview.client.RequestType;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);

        HttpClient client = new HttpClient(socket);

        // Отправка запроса GET
        client.sendRequest(RequestType.GET, "/app/rest?message=message");
        System.out.println(client.getResponseHeader().getStatusCode());
        System.out.println(client.getResponseBody());

        // Отправка запроса POST
        client.sendRequest(RequestType.POST, "/app/rest", "message", "test_message", "number", "143");
        System.out.println(client.getResponseHeader().getStatusCode());
        System.out.println(client.getResponseBody());

        socket.close();

    }
}
