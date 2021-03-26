package com.github.novikovmn.interview.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Класс выполняет запросы GET и POST и хранит последний ответ сервера
 */
public class HttpClient {
    private final Socket socket;
    private DataOutputStream out;
    private BufferedReader in;

    private ResponseHeader responseHeader;
    private String responseBody;

    public HttpClient(Socket socket) {
        this.socket = socket;
        try {
            this.out = new DataOutputStream(socket.getOutputStream());
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(RequestType requestType, String url, String... data) throws IOException {
        out.write((requestType.name() + " " + url + " HTTP/1.1\r\n").getBytes(StandardCharsets.UTF_8));
        out.write("HOST: localhost\r\n".getBytes(StandardCharsets.UTF_8));
        // Если запрос POST, то добавляем дополнительные данные в заголовок и формируем строку с передаваемыми данными
        // По-хорошему, тут ещё должно быть кодирование входных параметров по стандарту application/x-www-form-urlencoded,
        // Но это уже будет слишком
        if (requestType == RequestType.POST) {
            // Проверка, что число параметров data чётное, иначе не соберётся цепочка ключ-значение
            if (data.length % 2 > 0) {
                throw new IllegalArgumentException("Количество ключей и значений не совпадает");
            }
            StringBuilder dataStringBuilder = new StringBuilder();
            for (int i = 0; i < data.length; i+=2) {
                dataStringBuilder.append(data[i]).append("=").append(data[i + 1]).append("&");
            }
            // Убираем последний символ "&"
            dataStringBuilder.setLength(dataStringBuilder.length() - 1);
            out.write("Content-Type: application/x-www-form-urlencoded\r\n".getBytes(StandardCharsets.UTF_8));
            out.write(("Content-Length: " + dataStringBuilder.length() + "\r\n\r\n").getBytes(StandardCharsets.UTF_8));
            out.write(dataStringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        // Если запрос гет, до добавляем ещё один перенос строки, чтобы сервер видел конец заголовка запроса
        } else { out.write("\r\n".getBytes(StandardCharsets.UTF_8)); }
        out.flush();
        getResponse();
    }

    private void getResponse() throws IOException {
        char currentChar;
        StringBuilder header = new StringBuilder();
        StringBuilder stop = new StringBuilder();
        while (!stop.toString().equals("\r\n\r\n")) {
            currentChar = (char) in.read();
            if (currentChar == '\r' || currentChar == '\n') {
                stop.append(currentChar);
            } else {
                stop.setLength(0);
            }
            header.append(currentChar);
        }
        this.responseHeader = new ResponseHeader(header.toString());

        StringBuilder body = new StringBuilder();
        for (int i = 0; i < responseHeader.getContentLength(); i++) {
            body.append((char) in.read());
        }
        this.responseBody = body.toString();
    }

    public ResponseHeader getResponseHeader() { return responseHeader; }
    public String getResponseBody() { return responseBody; }
}
