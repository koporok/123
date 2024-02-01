package com.example.martialschool.server;


import com.example.martialschool.enity.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class ServerConnectionStudent {

    public static List<Student> getStudentsData() {
        List<Student> students = new ArrayList<>();

        try {
            String urlString = "http://localhost:8081/students/";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder responseData = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        responseData.append(line);
                    }

                    JSONArray jsonArray = new JSONArray(responseData.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonStudent = jsonArray.getJSONObject(i);
                        int id = jsonStudent.getInt("students_id");
                        String name = jsonStudent.getString("fullName");
                        String dateOfBirth;
                        if (jsonStudent.get("dateOfBirth") instanceof String) {
                            dateOfBirth = jsonStudent.getString("dateOfBirth");
                        } else {
                            // Обработка другого типа данных для "dateOfBirth", например:
                            dateOfBirth = String.valueOf(jsonStudent.get("dateOfBirth"));
                        }
                        // ... остаток кода ...
                    }
                }

            } else {
                System.out.println("GET Request - Response Code: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void deleteStudentFromServer(int studentId) {
        try {
            String urlString = "http://localhost:8081/students/" + studentId;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Успешно удалено");
            } else {
                // Обработка ошибки
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateStudentOnServer(Student student) {
        try {
            URL url = new URL("http://localhost:8081/students/" + student.getId());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Преобразование объекта Student в формат JSON
            String jsonData = "{\"id\":" + student.getId() + ", \"fullName\":\"" + student.getFullName() + "\", \"dateOfBirth\":\"" + student.getDateOfBirth() + "\", \"contactInformation\":\"" + student.getContactInformation() + "\", \"groupId\":" + student.getGroupId() + ", \"sportType\":\"" + student.getSportType() + "\", \"login\":\"" + student.getLogin() + "\"}";

            // Отправка данных на сервер
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Данные успешно обновлены");
            } else {
                System.out.println("Ошибка при обновлении данных: " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
