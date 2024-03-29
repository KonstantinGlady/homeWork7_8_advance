package lesson3.homework;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Task1 {

    private static final String[] INPUT_DATA = {
            "a",
            "b", "b", "b",
            "c",
            "d",
            "e", "e",
            "f",
            "g", "g", "g",
            "h",
            "g",
            "i"
    };


    public static void main(String[] args) {
        Map<String, Integer> frequencyByWord = new LinkedHashMap<>();
        for (String word : INPUT_DATA) {
//            Integer frequency = frequencyByWord.getOrDefault(word, 0);
//            frequencyByWord.put(word, frequency + 1);
//
//            frequencyByWord.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
            frequencyByWord.merge(word, 1, Integer::sum);
        }

        frequencyByWord.forEach((word, frequency) -> {
            System.out.println(word + ": " + frequency);
        });
    }
}
