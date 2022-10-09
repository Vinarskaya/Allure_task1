package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String city = new Faker(new Locale("ru")).address().city();
        return city;
    }

    public static String generateName(String locale) {
        String name = new Faker(new Locale("ru")).name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = new Faker(new Locale("ru")).phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            UserInfo user = new UserInfo(faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

