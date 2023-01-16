package ru.netology.bankinglogin.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));
    private DataHelper(){
    }
    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static VerificationCode getVerificationCode() {
        return new VerificationCode(faker.numerify("######"));
    }

    @Value
    public static class AuthInfo{
        String login;
        String password;
    }
    @Value
    public static class VerificationCode{
        String code;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode{
        private String id;
        private String user_id;
        private String code;
        private String created;
    }
}
