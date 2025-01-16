/**********************************************
 Workshop #01
 Course: APD545
 Last Name: Zadafiya
 First Name: Manav
 ID: 144095221
 Section: ZAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date:2024-09-22
 **********************************************/

import controller.MusicalInstrumentController;
import model.*;
import view.MusicalInstrumentView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Requirement 1: User Input for instrument Prices
        System.out.println("--: Requirement 1 :--");
        System.out.print("Enter the price for Drum: ");
        double drumPrice = scanner.nextDouble();
        System.out.print("Enter the price for Flute: ");
        double flutePrice = scanner.nextDouble();
        System.out.print("Enter the price for Guitar: ");
        double guitarPrice = scanner.nextDouble();
        System.out.print("Enter the price for Harp: ");
        double harpPrice = scanner.nextDouble();
        System.out.print("Enter the price for Xylophone: ");
        double xylophonePrice = scanner.nextDouble();

        MusicalInstrument[] instruments = {
                new Drum(drumPrice),
                new Flute(flutePrice),
                new Guitar(guitarPrice),
                new Harp(harpPrice),
                new Xylophone(xylophonePrice)
        };

        MusicalInstrumentView view = new MusicalInstrumentView();
        MusicalInstrumentController controller = new MusicalInstrumentController(instruments, view);

        // Requirement 2: Display the most expensive instrument
        controller.displayMostExpensiveInstrument();

        // Requirement 3: Display instruments in price descending order
        controller.displayInstrumentsByPrice();

        // Requirement 4: Display how instruments in a family make sound
        scanner.nextLine(); // Clear buffer
        System.out.print("--: Requirement 4 :--\nEnter an instrument family: ");
        String familyName = scanner.nextLine();
        controller.displayFamilySound(familyName);
    }
}
