package potter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BookPurchaseTest {

    BookPurchase book = new BookPurchase();

    @Test
    @DisplayName("Should return book price after purchase only one book")
    void shouldReturnSBookPrice_afterPurchaseOneBook(){

        Assertions.assertThat(book.getShoppingAmount(List.of("Kamień Filozoficzny"))).isEqualTo(8.0);
    }

    @Test
    @DisplayName("Should return amount with discount 5% after purchase of 2 different books")
    void shouldReturnAmountWith5Discount_afterPurchase2Books(){
        List<String> books = List.of("Kamień Filozoficzny","Komnata Tajemnic");
        Assertions.assertThat(book.getShoppingAmount(books)).isEqualTo(15.2);
    }



}
