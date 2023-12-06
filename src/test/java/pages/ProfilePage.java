package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    SelenideElement
            userNameValue = $("#userName-value"),
            emptyTable = $x("//*[contains(text(),'No rows found')]"),
            gitPocketBook = $("[id='see-book-Git Pocket Guide']");


    public ProfilePage checkEmptyTable() {
        emptyTable.shouldBe(visible);
        return this;
    }

    public ProfilePage checkGitPocketBook() {
        gitPocketBook.shouldBe(visible);
        return this;
    }

    public ProfilePage checkUserNameValue(String text) {
        userNameValue.shouldHave(text(text));
        return this;

    }
}