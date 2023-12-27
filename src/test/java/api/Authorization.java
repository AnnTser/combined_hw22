package api;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Data;
import models.LoginRequestModel;

import static io.restassured.RestAssured.given;
import static specs.ReqRespSpec.requestSpec;
import static specs.ReqRespSpec.responseSpec;

@Data
public class Authorization {
    @Step("Authorization")

    public Response getAuthResponse() {
        LoginRequestModel userLogin = new LoginRequestModel ("testtestov31","Testtestov31_%");
//        userLogin.setUserName("testtestov31");
//        userLogin.setPassword("Testtestov31_%");

        return given(requestSpec)
                .body(userLogin)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().response();
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

