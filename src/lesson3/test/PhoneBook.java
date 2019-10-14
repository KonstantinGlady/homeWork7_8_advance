package lesson3.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class PhoneBook {
    private Map<String, HashSet<String>> phoneBook;

    PhoneBook() {
        phoneBook = new HashMap<>();
    }

    void add(String name, String phone) {
        HashSet<String> number = phoneBook.getOrDefault(name, new HashSet<>());
        number.add (phone);
        phoneBook.put(name, number);
    }

    void get(String name) {
        System.out.println("Имя: " + name + ", номер телефона: " +
        phoneBook.getOrDefault(name, new HashSet<>()));

        // for (String key : phoneBook.keySet()) {
        //     String value = phoneBook.get(key);
        // }
        // System.out.println(name + " : " + phoneBook.get(name));
    }
} 