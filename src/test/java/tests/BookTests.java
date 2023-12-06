package tests;

import api.BookMoves;
import helpers.WithLogin;
import io.qameta.allure.Owner;
import models.AddBookModel;
import models.IsbnModel;
import models.LoginResponseModel;
import models.RemoveBookModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("testtestov31")
@Tag("delete")
public class BookTests extends TestBase {
    //   Authorization authorization = new Authorization();
    BookMoves bookMoves = new BookMoves();
    LoginResponseModel loginResponse = new LoginResponseModel();
    ProfilePage profilePage = new ProfilePage();

    @Test
    @WithLogin
    void addBookToProfileTest() {
        step("Delete all books from profile", () -> {
            bookMoves.deleteBooks(loginResponse);
        });
        step("Add book to profile", () -> {
            IsbnModel isbnModel = new IsbnModel("9781449325862");
            List<IsbnModel> isbnList = new ArrayList<>();
            isbnList.add(isbnModel);

            AddBookModel booksList = new AddBookModel();
            booksList.setUserId(loginResponse.getUserId());
            booksList.setIsbnCollection(isbnList);

            bookMoves.addBook(loginResponse, booksList);
        });


        step("Check profile with book", () -> {
            open("/profile");
            profilePage.checkGitPocketBook();
        });
    }


    @Test
    @WithLogin
    void deleteBookFromProfileTest() {
        step("Delete all books from profile", () -> {
            bookMoves.deleteBooks(loginResponse);
        });
        step("Add book to profile", () -> {
            List<IsbnModel> isbnList = new ArrayList<>();
            IsbnModel isbnModel = new IsbnModel("9781449325862");
            isbnList.add(isbnModel);

            AddBookModel booksList = new AddBookModel();
            booksList.setUserId(loginResponse.getUserId());
            booksList.setIsbnCollection(isbnList);

            bookMoves.addBook(loginResponse, booksList);
        });
        step("Remove added book", () -> {
            RemoveBookModel removeBookModel = new RemoveBookModel("9781449325862", "1bac20f1-55eb-4cdc-b546-957c96333466");
            bookMoves.deleteBook(loginResponse, removeBookModel);
        });
        step("Check profile without book", () -> {
            open("/profile");
            profilePage.checkEmptyTable();
        });
    }
}
