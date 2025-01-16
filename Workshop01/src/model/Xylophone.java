package model;

public class Xylophone extends PercussionFamily implements IPlayable, IFixable {
    public Xylophone(double price) {
        super(price, "through resonators", "Each bar produces a different pitch");
    }

    @Override
    public String howToPlay() {
        return "with two mallets";
    }

    @Override
    public String howToFix() {
        return "replace bars";
    }

    @Override
    public String makeSound() {
        return "through resonators";
    }
}
