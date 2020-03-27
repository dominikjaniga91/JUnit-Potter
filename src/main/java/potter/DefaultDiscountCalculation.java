package potter;

import java.util.Map;
import static potter.BookPurchase.*;

public class DefaultDiscountCalculation implements DiscountCalculationStrategy {

    @Override
    public Double discountCalculation(Map<String, Integer> purchasedBooks) {

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
}
