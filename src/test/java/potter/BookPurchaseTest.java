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
    void shouldReturnAmountWithDiscount_afterPurchase3BooksAnd1TheSame(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 , "Więzień Askabanu",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(23.2);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase of 2 units of 2 different books")
    void shouldReturnAmountWithDiscount_afterPurchase4Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 , "Więzień Askabanu",2);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(30.4);
    }


    @Test
    @DisplayName("Should return amount with best discount after purchase of 3 different books and 1 doubled")
    void shouldReturnAmountWithDiscount_afterPurchase2BooksAnd2TheSame(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 , "Więzień Askabanu",1 , "Czara Ognia",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(29.6);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase of 6 books - 2x2 and 2x1")
    void shouldReturnAmountWithDiscount_afterPurchase6Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 ,"Komnata Tajemnic",2 , "Więzień Askabanu",1 , "Czara Ognia",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(40.8);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase of 6 books - 5x1 and 1x1")
    void shouldReturnAmountWithDiscount_afterPurchase5and1Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 ,"Komnata Tajemnic",1 , "Więzień Askabanu",1 , "Czara Ognia",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(38.0);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase of 2 different books and 3 doubled")
    void shouldReturnAmountWithDiscount_afterPurchase5BooksAnd3TheSame(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 ,"Komnata Tajemnic",2 , "Więzień Askabanu",2 , "Czara Ognia",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(51.2);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase 23 books - 3x5 books and 2x4 books")
    void shouldReturnAmountWithDiscount_afterPurchase3x5BooksAnd2x4Boks(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",5 ,"Komnata Tajemnic",5 , "Więzień Askabanu",5 , "Czara Ognia",4 , "Zakon Feniksa",4);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(141.2);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase 6 books - 2 units of each of 3 different books")
    void shouldReturnAmountWithDiscount_afterPurchase2x3Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 , "Więzień Askabanu",2 , "Czara Ognia",2);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(43.2);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase 8 books - 4x2")
    void shouldReturnAmountWithDiscount_afterPurchase2x4Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 ,"Komnata Tajemnic",2 , "Więzień Askabanu",2 , "Czara Ognia",2);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(51.2);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase 7 books - 5 different and 2 doubled")
    void shouldReturnAmountWithDiscount_afterPurchase7Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",2 ,"Komnata Tajemnic",2 , "Więzień Askabanu",1 , "Czara Ognia",1 , "Zakon Feniksa",1);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(45.2);
    }

    @Test
    @DisplayName("Should return amount with best discount after purchase 20 books - 5x2, 3x2 and 4x1")
    void shouldReturnAmountWithDiscount_afterPurchase20Books(){
        Map<String,Integer> books = Map.of("Kamień Filozoficzny",5 ,"Komnata Tajemnic",5 , "Więzień Askabanu",4 , "Czara Ognia",3 , "Zakon Feniksa",3);
        Assertions.assertThat(book.getShoppingCost(books)).isEqualTo(126.4);
    }


}
