package lesson1.part2;

public class Animal {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public void animalInfo() {
        System.out.println("Animal name is " + name);
    }

    public void jump() {
        System.out.println("Animal jumped");
    }

    public String getName() {
        return name;
    }

//    public void voice() {
//        System.out.println("Животное издало какой-то звук");
//    }
}
