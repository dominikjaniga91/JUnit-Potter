package potter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class BookPurchase {

    Map<String, Double> books = Map.of("Kamień Filozoficzny", 8.0);



    public double getShoppingAmount(String bookTitle) {

        return Objects.requireNonNullElse(books.get(bookTitle), 0.0);
    }
}
