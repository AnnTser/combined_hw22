package api;

import io.qameta.allure.Step;
import models.AddBooksListRequestModel;
import models.DeleteBookResponseModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.ReqRespSpec.requestSpec;
import static specs.ReqRespSpec.responseSpec;

public class BooksApi {

    @Step("Delete books from profile")
    public void deleteAllBooks(LoginResponseModel loginResponse) {
        given(requestSpec)
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }

    @Step("Add book to profile")
    public void addBook(LoginResponseModel loginResponse, AddBooksListRequestModel booksList) {
        given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(booksList)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(201);
    }


    public void deleteBook(LoginResponseModel loginResponseModel, DeleteBookResponseModel deleteModel) {
        given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponseModel.getToken())
                .body(deleteModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }
}
