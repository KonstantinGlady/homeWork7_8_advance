package lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest {

    public static void main(String[] args) {
        String result = testFinally();
        System.out.println(result);
    }

    private static String testFinally() {
        try(FileInputStream fis = new FileInputStream("testFile.txt")) {
            byte[] bytes = fis.readAllBytes();
            return new String(bytes);
        } catch (FileNotFoundException e) {
            System.out.println("Файла testFile.txt не существует");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
//        } finally {
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test finally");
//        }
        return "Была ошибка";
    }
}
