package lesson1.part2;

public class Cat extends Animal {

    private final String color;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    public void catInfo() {
        System.out.println("Cat name is " + super.getName() + "; color - " + color);
    }
}
