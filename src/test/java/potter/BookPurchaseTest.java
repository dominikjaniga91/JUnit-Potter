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

    @Test
    @DisplayName("Should return amount with discount 10% after purchase of 3 different books")
    void shouldReturnAmountWith10Discount_afterPurchase3Books(){
        List<String> books = List.of("Kamień Filozoficzny","Komnata Tajemnic", "Zakon Feniksa");
        Assertions.assertThat(book.getShoppingAmount(books)).isEqualTo(21.6);
    }

    @Test
    @DisplayName("Should return amount with discount 20% after purchase of 4 different books")
    void shouldReturnAmountWith20Discount_afterPurchase4Books(){
        List<String> books = List.of("Kamień Filozoficzny","Komnata Tajemnic", "Więzień Askabanu", "Zakon Feniksa");
        Assertions.assertThat(book.getShoppingAmount(books)).isEqualTo(25.6);
    }



}
