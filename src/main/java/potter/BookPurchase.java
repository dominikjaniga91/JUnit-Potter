package potter;

import java.util.*;

public class BookPurchase {

//    Map<String, Double> bookStore = Map.of("Kamień Filozoficzny", 8.0,
//                                            "Komnata Tajemnic",8.0,
//                                            "Więzień Askabanu",8.0,
//                                            "Czara Ognia",8.0,
//                                            "Zakon Feniksa", 8.0);

    private final double BOOK_PRICE = 8.0;

    Map<Integer, Double> discounts = Map.of(1, 1.0,
                                            2, 0.95,
                                            3,0.9,
                                            4,0.8,
                                            5,0.75);

    public double getShoppingAmount(Map<String,Integer> purchasedBooks) {

        double shoppingAmount = 0.0;
        int availableBooks = 0;
        int amountOfBooks = 0;
        int maxAmountOfOneBook = mostNumerousBook(purchasedBooks);

        for (Map.Entry<String,Integer> book :  purchasedBooks.entrySet()) {

            shoppingAmount += BOOK_PRICE;
            availableBooks++;

        }

        shoppingAmount *= discounts.get(availableBooks);

        return shoppingAmount;
    }

    private int mostNumerousBook(Map<String,Integer> purchasedBooks){
        int maxValue = 0;
        for (int i=1; i<= purchasedBooks.values().size(); i++) {
            maxValue = Math.max(i, (i - 1));
        }
        return maxValue;
    }
}
