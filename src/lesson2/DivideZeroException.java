package lesson2;

public class DivideZeroException extends ArithmeticException {

    public DivideZeroException() {
        super("Произошло деление на ноль!");
    }
}
