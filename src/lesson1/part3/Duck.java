package lesson1.part3;

import lesson1.part2.Animal;

public class Duck extends Animal implements Pet, Waterfowl {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Кря!");
    }

    @Override
    public void loveMaster() {
        System.out.println("Кря кря кря хозяин!");
    }

    @Override
    public boolean isUseful() {
        return true;
    }

    @Override
    public int swim() {
        System.out.println("Утка плывет");
        return 150;
    }
}
