package lesson3;

import java.util.*;

public class HashMapExample {

    public static void main(String args[]) {
//        Map<String, String> hm = new HashMap<>();
//        Map<String, String> hm = new LinkedHashMap<>();
        Map<String, String> hm = new TreeMap<>();
        hm.put("Russia", "Moscow");
//        hm.put("Russia", "Smolensk");
        hm.put("France", "Paris");
        hm.put("Germany", "Berlin");
        hm.put("Norway", "Oslo");

        List<Integer> integers = new ArrayList<>();
        integers.add(3);

        hm.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

//        Map<Person, Integer> salaryByWorker = new HashMap<>();
//        salaryByWorker.put(new Person("Oleg", 27), 100_000);
//        salaryByWorker.put(new Person("Alexey", 29), 150_000);
//
//        System.out.println("Alexey salary:" + salaryByWorker.get(new Person("Alexey", 29)));

//        System.out.println(hm.get("France"));

//        for (Map.Entry<String, String> o : hm.entrySet()) {
//            System.out.println(o.getKey() + ": " + o.getValue());
//        }
        for (String key : hm.keySet()) {
            String value = hm.get(key);
        }

//
//        hm.put("Germany", "Berlin2");
//        System.out.println("New Germany Entry: " + hm.get("Germany"));
    }

}
