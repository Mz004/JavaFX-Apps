package model;

public class Flute extends WoodwindFamily implements IPlayable {
    public Flute(double price) {
        super(price, "guiding a stream of air", "Fundamental pitch is middle C");
    }

    @Override
    public String howToPlay() {
        return "by blowing into the flute";
    }

    @Override
    public String makeSound() {
        return "guiding a stream of air";
    }
}
