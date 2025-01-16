package view;

import model.MusicalInstrument;

import java.text.DecimalFormat;

public class MusicalInstrumentView {
    DecimalFormat df = new DecimalFormat("#.00");

    public void displayInstrumentDetails(MusicalInstrument instrument) {
        System.out.println("--: Requirement 2 :--");
        System.out.println("The most expensive instrument is: " + instrument);
        System.out.println(instrument + "’s cost is: $" + df.format(instrument.getPrice()));
        if (instrument instanceof model.IPlayable) {
            System.out.println(instrument + " is played: " + ((model.IPlayable) instrument).howToPlay());
        }
        if (instrument instanceof model.IFixable) {
            System.out.println(instrument + " fixing: " + ((model.IFixable) instrument).howToFix());
        }
        System.out.println(instrument + " pitch type: " + instrument.getPitchType());
    }

    public void displayFamilySound(MusicalInstrument[] instruments, String familyName) {
        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument + " makes sound: " + instrument.makeSound());
        }
    }

    public void displayInstrumentsByPrice(MusicalInstrument[] instruments) {
        System.out.println("--: Requirement 3 :--");
        System.out.print("Instruments in price descending order:\n [");
        for (int i = 0; i < instruments.length; i++) {
            System.out.print(instruments[i]);
            if (i < instruments.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
