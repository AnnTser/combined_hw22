package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.AddBookModel;
import models.RemoveBookModel;

import static io.restassured.RestAssured.given;
import static specs.ReqRespSpec.requestSpec;
import static specs.ReqRespSpec.responseSpec;

public class BookMoves {
    @Step("Add book to profile")
    public void addBook(Response authResponse, String isbn)  {

        AddBookModel addBookModel = new AddBookModel();
        AddBookModel.CollectionBooks collectionBooks = new AddBookModel.CollectionBooks();
        collectionBooks.setIsbn(isbn);
        addBookModel.getIsbnCollection().add(collectionBooks);
        addBookModel.setUserId(authResponse.path("userId"));

        given(requestSpec)
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .body(addBookModel)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(201);
    }

    @Step("Delete book from profile")
    public void deleteBook(Response authResponse, String isbn){

        RemoveBookModel removeBookModel = new RemoveBookModel();
        removeBookModel.setIsbn(isbn);
        removeBookModel.setUserId(authResponse.path("userId"));

        given(requestSpec)
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .body(removeBookModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }

}

