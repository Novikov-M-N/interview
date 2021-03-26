package com.github.novikovmn.interview.client;


/**
 * Объект - заголовок ответа HTTP. Собирает себя из последовательности символов, хранит и выдаёт данные заголовка
 */
public class ResponseHeader {
    private int statusCode;
    private String contentType;
    private int contentLength;
    private String date;

    public ResponseHeader(String header) {
        // Разбираем заголовок на строки
        String[] headerLines = header.split("\r\n");
        // Код ответа достаём из первой строки заголовка
        this.statusCode = Integer.parseInt(headerLines[0].split(" ")[1]);

        // Остальные строки парсим по одной и достаём оттуда параметры заголовка
        for (int i = 1; i < headerLines.length; i++) {

            // Параметр указан до первого пробела, дальше - его значение
            String[] headerLine = headerLines[i].split(" ");
            String parameter = headerLine[0];

            // Значение собираем обратно из строки, разобранной на предыдущем шаге
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < headerLine.length; j++) {
                sb.append(headerLine[j]).append(" ");
            }
            // Удаляем последний пробел
            sb.setLength(sb.length() - 1);
            String value = sb.toString();

            // Отправляем параметр в нужное поле объекта
            switch (parameter) {
                case "Content-Type:" -> this.contentType = value;
                case "Content-Length:" -> this.contentLength = Integer.parseInt(value);
                case "Date:" -> this.date = value;
            }
        }
    }

    public int getStatusCode() { return statusCode; }
    public String getContentType() { return contentType; }
    public int getContentLength() { return contentLength; }
    public String getDate() { return date; }
}
