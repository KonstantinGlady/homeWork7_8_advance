package lesson1.homework.participant;

public class AbstractParticipant implements Participant {

    protected final String name;
    protected final int jumpHeight;
    protected final int maxRunLength;

    public AbstractParticipant(String name, int jumpHeight, int maxRunLength) {
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
}
