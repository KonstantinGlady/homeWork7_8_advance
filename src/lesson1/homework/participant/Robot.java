package lesson1.homework.participant;

public class Robot implements Participant {

    private final String model;
    private final int jumpHeight;
    private final int maxRunLength;

    public Robot(String model, int jumpHeight, int maxRunLength) {
        this.model = model;
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
        return "Robot{" +
                "model='" + model + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", maxRunLength=" + maxRunLength +
                '}';
    }
}
