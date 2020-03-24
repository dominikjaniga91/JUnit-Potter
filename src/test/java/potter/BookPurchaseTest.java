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
    void shouldReturnSBookPrice_afterPurchaseOneBook(){

        Assertions.assertThat(book.getShoppingAmount("Kamień Filozoficzny")).isEqualTo(8.0);
    }




}
