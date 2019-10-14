package lesson3.homework;

import java.util.LinkedHashMap;
import java.util.Map;

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
//            Integer frequency = frequencyByWord.get(word);
//            if (frequency == null) {
//                frequency = 0;
//            }
//            frequencyByWord.put(word, frequency);
//
//            frequencyByWord.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);

            frequencyByWord.merge(word, 1, Integer::sum);
        }

        frequencyByWord.forEach((word, frequency) -> {
            System.out.println(word + ": " + frequency);
        });
    }
}
