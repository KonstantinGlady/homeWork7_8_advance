package lesson2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        readFile();
//        try {
//            readFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        while (true) {
            try {
                int digit = scanner.nextInt();
                int c = 5 / digit;
                System.out.println(c);
            } catch (ArithmeticException | InputMismatchException e) {
//                e.printStackTrace();
                System.out.println("Деление на ноль");
                break;
            } catch (Exception e) {
                System.out.println("Unknown error: " + e.getMessage());
                e.printStackTrace();
                break;
                /* catch (InputMismatchException e) {
                System.out.println("Некорретный формат данных");
                break;
            }*/
            }
        }
    }

    private static void readFile() throws IOException, ArithmeticException {
        Files.readAllBytes(Paths.get("testFile.txt"));
    }
}
