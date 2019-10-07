package lesson1.homework.participant;

public class Person implements Participant {

    private final String name;
    private final int jumpHeight;
    private final int maxRunLength;

    public Person(String name, int jumpHeight, int maxRunLength) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.maxRunLength = maxRunLength;
    }

    @Override
    public int run() {
        return maxRunLength;
    }

    @Override
    public int jump() {
        return  jumpHeight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", maxRunLength=" + maxRunLength +
                '}';
    }
}
