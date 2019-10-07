package lesson1.homework.participant;

//public class Cat extends AbstractParticipant {
public class Cat implements Participant {

//    public Cat(String name, int jumpHeight, int maxRunLength) {
//        super(name, jumpHeight, maxRunLength);
//    }

    private final String name;
    private final int jumpHeight;
    private final int maxRunLength;

    public Cat(String name, int jumpHeight, int maxRunLength) {
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
        return jumpHeight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", maxRunLength=" + maxRunLength +
                '}';
    }
}
