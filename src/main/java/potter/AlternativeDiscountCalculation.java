package potter;

import java.util.Map;
import static potter.BookPurchase.*;

public class AlternativeDiscountCalculation implements DiscountCalculationStrategy {

    @Override
    public Double discountCalculation(Map<String, Integer> purchasedBooks) {

        int amountOfBooks = getAmountOfBooks(purchasedBooks);

        //amountOfBooks = 5*rate + 4*rate + modulo
        int rate = amountOfBooks / 9;
        int modulo = amountOfBooks % 9;

        return BOOK_PRICE*(rate*(5* discounts.get(5) + 4*discounts.get(4)) + modulo*discounts.get(modulo));
    }

}
