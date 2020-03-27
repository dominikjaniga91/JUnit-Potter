package potter;

import java.util.Map;
import static potter.BookPurchase.*;

public class DefaultDiscountCalculation extends DiscountCalculationStrategy {

    @Override
    public Double calculation(Map<String, Integer> books) {

        double overallCost = 0.0;
        int units = gatMaxUnitsOfSingleBook(books);

        for(int i=1; i <= units; i++){
            int discountLevel = 0;
            double cost = 0.0;   // temporary cost of several different books
            for (Map.Entry<String,Integer> book :  books.entrySet()) {

                if(book.getValue() >= i){
                    cost += BOOK_PRICE;
                    discountLevel++;
                }
            }
            cost *= discounts.get(discountLevel);
            overallCost += cost;
        }
        return overallCost;
    }
}
