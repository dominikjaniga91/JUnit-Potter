package potter;

import java.util.Map;
import static potter.BookPurchase.*;

public class PurchaseEightBooksCalculation extends DiscountCalculationStrategy {

    @Override
    public Double calculation(Map<String, Integer> purchasedBooks) {
        return 2*4*BOOK_PRICE* discounts.get(4);
    }
}
