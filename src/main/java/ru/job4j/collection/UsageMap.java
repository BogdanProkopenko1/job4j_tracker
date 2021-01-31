package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> account = new HashMap<>();
        account.put("pvzarea@gmail.com", "Prokopenko Bogdan Viktorovich");
        account.put("integer.args@gmail.com", "Zotov Dmitry Sergeyevich");
        for (String key : account.keySet()) {
            System.out.println(account.get(key));
        }
    }
}
