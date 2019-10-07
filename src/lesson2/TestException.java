package lesson2;

public class TestException {

    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            justMethod(a, b);
        } catch (DivideZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void justMethod(int a, int b) {
        if (b == 0) {
//            throw new ArithmeticException("Деление на ноль");
            throw new DivideZeroException();
        }
        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Error! " + e.getMessage());
        }
        System.out.println("Finish");
    }
}
