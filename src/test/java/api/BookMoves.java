package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.AddBookModel;
import models.LoginResponseModel;
import models.RemoveBookModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.ReqRespSpec.requestSpec;
import static specs.ReqRespSpec.responseSpec;

public class BookMoves {

    @Step("Delete books from profile")
    public void deleteBooks(LoginResponseModel loginResponse) {

        given(requestSpec)
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserID", loginResponse.getUserID())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }

    @Step("Add book to profile")
    public void addBook(LoginResponseModel loginResponse, AddBookModel books) {
        given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(books)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(201);

    }

    public void deleteBook(LoginResponseModel loginResponseModel, RemoveBookModel delete) {
        given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponseModel.getToken())
                .body(delete)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .statusCode(204);
    }
}
