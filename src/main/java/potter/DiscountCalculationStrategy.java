package potter;

import java.util.Map;

public interface DiscountCalculationStrategy {

    Double calculation(Map<String,Integer> purchasedBooks);

}
