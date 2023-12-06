package tests;
import helpers.WithLogin;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginTest  extends TestBase {

    ProfilePage profilePage = new ProfilePage();

    @Test
    @WithLogin
    @Tag("Authorization")
    void loginTest() {
        step("Authorization and check user name", () -> {
            open("/profile");
            profilePage.checkUserNameValue(loginRequestModel.getUserName());
        });
    }

}
