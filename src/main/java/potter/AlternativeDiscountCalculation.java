package potter;

import java.util.Map;
import static potter.BookPurchase.*;

public class AlternativeDiscountCalculation implements DiscountCalculationStrategy {

    @Override
    public Double calculation(Map<String, Integer> books) {

        int amountOfBooks = getAmountOfBooks(books);

        //amountOfBooks = 5*rate + 4*rate + modulo
        int rate = amountOfBooks / 9;
        int modulo = amountOfBooks % 9;

        return BOOK_PRICE*(rate*(5* discounts.get(5) + 4*discounts.get(4)) + modulo*discounts.get(modulo));
    }

}
