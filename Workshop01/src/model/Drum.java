package model;

public class Drum extends PercussionFamily implements IPlayable, IFixable {
    public Drum(double price) {
        super(price, "vibrating stretched membrane", "Sonic pitch");
    }

    @Override
    public String howToPlay() {
        return "by hitting the membrane";
    }

    @Override
    public String howToFix() {
        return "replace the membrane";
    }

    @Override
    public String makeSound() {
        return "vibrating stretched membrane";
    }
}
