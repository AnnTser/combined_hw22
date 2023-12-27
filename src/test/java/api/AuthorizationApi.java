package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.ReqRespSpec.requestSpec;
import static specs.ReqRespSpec.responseSpec;

public class AuthorizationApi {
    public LoginResponseModel login(LoginRequestModel loginRequestModel){
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




























//    @Test
//    void successfulLoginWithApiTest() {
//        String authData = "{\"userName\":\"testtestov31\",\"password\":\"Testtestov31_%\"}";
//
//        Response authResponse = given()
//                .log().uri()
//                .log().method()
//                .log().body()
//                .contentType(JSON)
//                .body(authData)
//                .when()
//                .post("/Account/v1/Login")
//                .then()
//                .log().status()
//                .log().body()
//                .statusCode(200)
//                .extract().response();
//
//        open("/favicon.ico");
//        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.path("userId")));
//        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.path("expires")));
//        getWebDriver().manage().addCookie(new Cookie("token", authResponse.path("token")));
//
//        open("/profile");
//        $("#userName-value").shouldHave(text(login));
//    }
//}

