package potter;


import java.util.*;
import java.util.stream.Stream;

public class BookPurchase {

    Map<String, Double> bookStore = Map.of("Kamień Filozoficzny", 8.0,
                                        "Komnata Tajemnic",8.0);

    Map<Integer, Double> discounts = Map.of(1, 1.0,
                                            2, 0.95,
                                            3,0.9,
                                            4,0.8,
                                            5,0.75);

    public double getShoppingAmount(List<String> bookTitles) {

        double shoppingAmount = 0.0;
        int availableBooks = 0;

        for (String bookTitle :  bookTitles ) {
            for (Map.Entry<String,Double> book : bookStore.entrySet()  ) {
                if(bookTitle.equals(book.getKey())){
                    shoppingAmount += book.getValue();
                    availableBooks++;
                }
            }
        }

        shoppingAmount *= discounts.get(availableBooks);

        return shoppingAmount;
    }


}
