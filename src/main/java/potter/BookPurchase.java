package potter;

import java.util.*;

public class BookPurchase {

    final static double BOOK_PRICE = 8.0;
    DiscountCalculationStrategy calculation;

    static Map<Integer, Double> discounts = Map.of(1, 1.0,
                                            2, 0.95,
                                            3, 0.9,
                                            4, 0.8,
                                            5, 0.75);

    static int gatMaxUnitsOfSingleBook(Map<String,Integer> purchasedBooks){
        return purchasedBooks.values().stream().reduce(0,Integer::max);
    }

    static int getAmountOfBooks(Map<String, Integer> purchasedBooks) {
        return purchasedBooks.values().stream().reduce(0,Integer::sum);
    }

    public double getShoppingCost(Map<String,Integer> purchasedBooks) {

        if(getAmountOfBooks(purchasedBooks) < 8){
            return new DefaultDiscountCalculation().discountCalculation(purchasedBooks);
        }else if(getAmountOfBooks(purchasedBooks) == 8){
            return new PurchaseEightBooksCalculation().discountCalculation(purchasedBooks);
        }else{
            return Math.min(
                    new DefaultDiscountCalculation().discountCalculation(purchasedBooks),
                    new AlternativeDiscountCalculation().discountCalculation(purchasedBooks)
            );
        }

    }

}
