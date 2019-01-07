package ru.lebedev.se.lesson3.validpass;

/*
Необходимо из консоли считать пароль и проверить валидность,
результат будет true или false

Требования:
1. Пароль должен быть не менее 8ми символов.
2. В пароле должно быть число
3. В пароле должна быть хотя бы 1 строчная буква
4. В пароле должна быть хотя бы 1 заглавная буква
5. Не должно быть пробелов
6. Должен быть спец. символ
---------------------------------------------------
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validation {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String password;
        System.out.println("Введите пароль. (Не менее 8 символов, a-z, без пробела, не менее 1 строчной, 1 прописной, 1 спецсимвол");
        while (true) {
            password = reader.readLine();
            System.out.print("Не менее 8 символов, 1 строчная, 1 прописная, 1 спецсимвол из списка, 1 число: ");
            System.out.println(password.matches("(?=^[a-zA-Z0-9!@#$&%_-]{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$&%])(?=.*\\d).*$"));
        }
    }

}
