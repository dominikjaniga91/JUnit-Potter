package potter;

import java.util.*;

public class BookPurchase {

    private final double BOOK_PRICE = 8.0;

    Map<Integer, Double> discounts = Map.of(1, 1.0,
                                            2, 0.95,
                                            3, 0.9,
                                            4, 0.8,
                                            5, 0.75);

    public double getShoppingCost(Map<String,Integer> purchasedBooks) {

        if(getAmountOfBooks(purchasedBooks) < 8){
            return defaultDiscountCalculation(purchasedBooks);
        }else if(getAmountOfBooks(purchasedBooks) == 8){
            return  2*4*BOOK_PRICE* discounts.get(4);
        }else{
            return Math.min(defaultDiscountCalculation(purchasedBooks), alternativeDiscountCalculation(purchasedBooks));
        }

    }

    public double defaultDiscountCalculation(Map<String,Integer> purchasedBooks) {

        double overallCost = 0.0;
        int maxUnitsOfSingleBook = gatMaxUnitsOfSingleBook(purchasedBooks);

        for(int i=1; i <= maxUnitsOfSingleBook; i++){
            int availableBooks = 0;
            double shoppingAmount = 0.0;
            for (Map.Entry<String,Integer> book :  purchasedBooks.entrySet()) {

                if(book.getValue() >= i){
                    shoppingAmount += BOOK_PRICE;
                    availableBooks++;
                }
            }
            shoppingAmount *= discounts.get(availableBooks);
            overallCost += shoppingAmount;
        }
        return overallCost;
    }

    private int gatMaxUnitsOfSingleBook(Map<String,Integer> purchasedBooks){
        return purchasedBooks.values().stream().reduce(0,Integer::max);
    }

    private double alternativeDiscountCalculation(Map<String,Integer> purchasedBooks){

        int amountOfBooks = getAmountOfBooks(purchasedBooks);

        //amountOfBooks = 5*rate + 4*rate + modulo
        int rate = amountOfBooks / 9;
        int modulo = amountOfBooks % 9;

        return BOOK_PRICE*(rate*(5* discounts.get(5) + 4*discounts.get(4)) + modulo*Objects.requireNonNullElse(discounts.get(modulo),discounts.get(modulo/2)));
    }

    private int getAmountOfBooks(Map<String, Integer> purchasedBooks) {
        return purchasedBooks.values().stream().reduce(0,Integer::sum);
    }
}
