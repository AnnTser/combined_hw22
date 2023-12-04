package tests;

import api.BookMoves;
import helpers.WithLogin;
import org.junit.jupiter.api.Test;
import api.Authorization;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BookTests extends TestBase {

    @Test
    @WithLogin
    void deleteBook (){

    BookMoves moves = new BookMoves();
    moves.addBook(authResponse, "9781449325862");
    moves.deleteBook(authResponse, "9781449325862");

    step("Check delete book", () -> {
            open("/profile");
            $("[href*='/profile?book=9781449325862']").shouldNotBe(exist);
        });
    }


}
