package com.workshop.workshop02.model;

import java.util.List;

@SuppressWarnings("ALL")
public class Pizza {
    private final String customerName;
    private final String customerPhone;
    private final String pizzaSize;
    private final String crustType;
    private final int quantity;
    private final List<String> toppings;
    private final double price;
    private static final double TAX_RATE = 0.13;

    public Pizza(String customerName, String customerPhone, String pizzaSize, String crustType, int quantity, List<String> toppings) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.quantity = quantity;
        this.toppings = toppings;
        this.price = calculatePrice();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public String getCrustType() {
        return crustType;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

    private double calculatePrice() {
        double basePrice = switch (pizzaSize.toLowerCase()) {
            case "small" -> 7.0;
            case "medium" -> 10.0;
            case "large" -> 13.0;
            case "extra large" -> 15.0;
            default -> 0;
        };

        double toppingsCost = 0;
        for (String topping : toppings) {
            if (isVegBased(topping)) {
                toppingsCost += 1.10;
            } else {
                toppingsCost += 2.15;
            }
        }

        return (basePrice + toppingsCost) * quantity;
    }

    private boolean isVegBased(String topping) {
        return topping.equalsIgnoreCase("Pineapple") || topping.equalsIgnoreCase("Mushrooms") ||
                topping.equalsIgnoreCase("Jalapeno") || topping.equalsIgnoreCase("Spinach") ||
                topping.equalsIgnoreCase("Sun Dried Tomatoes") || topping.equalsIgnoreCase("Roasted Garlic");
    }

    public double getTotalWithTax() {
        return price + (price * TAX_RATE);
    }

    @Override
    public String toString() {
        return "-------------------------------------\n" +
                "         Pizza Paradise       \n" +
                "-------------------------------------\n" +
                "Customer Name    : " + customerName + "\n" +
                "Customer Phone   : " + customerPhone + "\n" +
                "Pizza Size       : " + pizzaSize + "\n" +
                "Crust Type       : " + crustType + "\n" +
                "Quantity         : " + quantity + "\n" +
                "Toppings         : " + (toppings.isEmpty() ? "None" : String.join(", ", toppings)) + "\n" +
                "-------------------------------------\n" +
                "Total (before tax): $" + String.format("%.2f", price) + "\n" +
                "Total (with tax)  : $" + String.format("%.2f", getTotalWithTax()) + "\n" +
                "-------------------------------------";
    }

}
