package potter;

import java.util.*;

public class BookPurchase {

    final static double BOOK_PRICE = 8.0;
    static Map<Integer, Double> discounts = Map.of(1, 1.0,
                                            2, 0.95,
                                            3, 0.9,
                                            4, 0.8,
                                            5, 0.75);

    static int gatMaxUnitsOfSingleBook(Map<String,Integer> books){
        return books.values().stream().reduce(0,Integer::max);
    }

    static int getAmountOfBooks(Map<String, Integer> books) {
        return books.values().stream().reduce(0,Integer::sum);
    }

    public double getShoppingCost(Map<String,Integer> books) {

        if(getAmountOfBooks(books) < 8){
            return new DefaultDiscountCalculation().calculation(books);
        }else if(getAmountOfBooks(books) == 8){
            return new PurchaseEightBooksCalculation().calculation(books);
        }else{
            return Math.min(
                    new DefaultDiscountCalculation().calculation(books),
                    new AlternativeDiscountCalculation().calculation(books)
            );
        }

    }

}
