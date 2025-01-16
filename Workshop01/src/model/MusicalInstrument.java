package model;

public abstract class MusicalInstrument implements Comparable<MusicalInstrument> {
    protected double price;
    protected String makeSound;
    protected String pitchType;

    public MusicalInstrument(double price, String makeSound, String pitchType) {
        this.price = price;
        this.makeSound = makeSound;
        this.pitchType = pitchType;
    }

    public double getPrice() {
        return price;
    }

    public abstract String makeSound();

    public String getPitchType() {
        return pitchType;
    }

    @Override
    public int compareTo(MusicalInstrument other) {
        return Double.compare(other.getPrice(), this.price);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

