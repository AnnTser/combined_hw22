package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.ReqRespSpec.requestSpec;
import static specs.ReqRespSpec.responseSpec;

public class AuthorizationApi {
    public LoginResponseModel login(LoginRequestModel loginRequestModel) {
        return given(requestSpec)
                .body(loginRequestModel)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(LoginResponseModel.class);
    }
}

