package tests;
import helpers.WithLogin;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("testtestov33")
public class LoginTest  extends TestBase {

    ProfilePage profilePage = new ProfilePage();

    @Test
    @WithLogin
    @Tag("api")
    void loginTest() {
        step("Авторизация и проверка отображения имени", () -> {
            open("/profile");
            profilePage.verifyUserNameValue(loginRequestModel.getUserName());
        });
    }

}
