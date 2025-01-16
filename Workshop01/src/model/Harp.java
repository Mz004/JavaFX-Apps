package model;

public class Harp extends StringFamily implements IPlayable, IFixable {
    public Harp(double price) {
        super(price, "vibrating strings", "Has seven levels of pitch");
    }

    @Override
    public String howToPlay() {
        return "with the thumb and first three fingers";
    }

    @Override
    public String howToFix() {
        return "replace the strings";
    }

    @Override
    public String makeSound() {
        return "vibrating strings";
    }
}
