package model;

public class Guitar extends StringFamily implements IPlayable, IFixable {
    public Guitar(double price) {
        super(price, "vibrating strings", "Low to high pitch");
    }

    @Override
    public String howToPlay() {
        return "by strumming the strings";
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
