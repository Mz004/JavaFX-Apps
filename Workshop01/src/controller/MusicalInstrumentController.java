package controller;

import model.MusicalInstrument;
import view.MusicalInstrumentView;

import java.util.Arrays;

public class MusicalInstrumentController {
    private MusicalInstrument[] instruments;
    private MusicalInstrumentView view;

    public MusicalInstrumentController(MusicalInstrument[] instruments, MusicalInstrumentView view) {
        this.instruments = instruments;
        this.view = view;
    }

    public void displayMostExpensiveInstrument() {
        Arrays.sort(instruments);
        view.displayInstrumentDetails(instruments[0]);
    }

    public void displayInstrumentsByPrice() {
        Arrays.sort(instruments);
        view.displayInstrumentsByPrice(instruments);
    }

    public void displayFamilySound(String familyName) {
        MusicalInstrument[] filteredInstruments = Arrays.stream(instruments)
                .filter(instrument -> instrument.getClass().getSuperclass().getSimpleName().contains(familyName))
                .toArray(MusicalInstrument[]::new);
        view.displayFamilySound(filteredInstruments, familyName);
    }
}
