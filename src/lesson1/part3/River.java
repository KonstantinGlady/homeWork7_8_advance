package lesson1.part3;

public class River {

    private final String title;
    private final int length;

    public River(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public boolean doSwim(Waterfowl waterfowlAnimal) {
        int swimLength = waterfowlAnimal.swim();
        return swimLength >= length;
    }

    public static void main(String[] args) {
        Waterfowl duck = new Duck("duck");
        new River("Volga", 100).doSwim(duck);
    }
}
