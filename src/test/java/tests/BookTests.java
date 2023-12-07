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
//        step("Delete all books from profile", () -> {
//            bookMoves.deleteBooks(loginResponse);
//        });
        step("Add book to profile", () -> {
            IsbnModel isbnModel = new IsbnModel("9781449325862");
 //           List<IsbnModel> isbnList = new ArrayList<>();
 //           isbnList.add(isbnModel);

            AddBookModel booksList = new AddBookModel();
            booksList.setUserID(loginResponse.getUserID());
 //           booksList.setCollectionOfIsbns(isbnList);

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
//        step("Delete all books from profile", () -> {
//            bookMoves.deleteBooks(loginResponse);
//        });
        step("Add book to profile", () -> {
            IsbnModel  collectionOfIsbns [] = new IsbnModel[10];
            IsbnModel isbnModel = new IsbnModel("9781449325862");
            collectionOfIsbns[0]=isbnModel;

            AddBookModel booksList = new AddBookModel();
            booksList.setUserID(loginResponse.getUserID());
            booksList.setCollectionOfIsbns(collectionOfIsbns);

            bookMoves.addBook(loginResponse, booksList);
        });


        step("Remove added book", () -> {
            RemoveBookModel removeBookModel = new RemoveBookModel("9781449325862", "6b11b363-9eed-4a00-9469-51d95bed4ecf");
                                                                                             //6b11b363-9eed-4a00-9469-51d95bed4ecf
            bookMoves.deleteBook(loginResponse, removeBookModel);
        });


        step("Check profile without book", () -> {
            open("/profile");
            profilePage.checkEmptyTable();
        });
    }
}
