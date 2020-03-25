package potter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class BookPurchaseTest {

    BookPurchase book = new BookPurchase();

    @Test
    @DisplayName("Should return book price after purchase only one book")
    void shouldReturnSBookPrice_afterPurchaseOneBook(){

        Assertions.assertThat(book.getShoppingCost(Map.of("Kamień Filozoficzny",1))).isEqualTo(8.0);
    }

    @Test
    @DisplayName("Should return amount with discount 5% after purchase of 2 different books")
    void shouldReturnAmountWith5Discount_afterPurchase2Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",1 ,"Komnata Tajemnic",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(15.2);
    }

    @Test
    @DisplayName("Should return amount with discount 10% after purchase of 3 different books")
    void shouldReturnAmountWith10Discount_afterPurchase3Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",1 ,"Komnata Tajemnic",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(21.6);
    }

    @Test
    @DisplayName("Should return amount with discount 20% after purchase of 4 different books")
    void shouldReturnAmountWith20Discount_afterPurchase4Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",1 ,"Komnata Tajemnic",1 , "Więzień Askabanu",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(25.6);
    }

    @Test
    @DisplayName("Should return amount with discount 25% after purchase of 5 different books")
    void shouldReturnAmountWith25Discount_afterPurchase5Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",1 ,"Komnata Tajemnic",1 , "Więzień Askabanu",1 , "Czara Ognia",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(30.0);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase of 2 different books and 1 doubled")
    void shouldReturnAmountWithDiscount_afterPurchase2BooksAnd2TheSame(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 , "Więzień Askabanu",1 , "Czara Ognia",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(29.6);
    }


    @Test
    @DisplayName("Should return amount with best discount after purchase of 2 different books and 3 doubled")
    void shouldReturnAmountWithDiscount_afterPurchase5BooksAnd3TheSame(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 ,"Komnata Tajemnic",2 , "Więzień Askabanu",2 , "Czara Ognia",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(51.2);
    }



}
