package lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OutOfMemoryTest {

    public static void main(String[] args) {
        String str = "Кончилась память!";
        List<String> collection = new ArrayList<>();
        try {
            while (true) {
                UUID uuid = UUID.randomUUID();
                collection.add(uuid.toString());
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.out.println(str);
            System.out.println("String count is " + collection.size());
        }
    }
}
