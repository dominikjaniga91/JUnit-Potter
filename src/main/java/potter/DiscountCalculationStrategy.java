package potter;

import java.util.Map;

public interface DiscountCalculationStrategy {

    Double discountCalculation(Map<String,Integer> purchasedBooks);

}
