package ru.netology.bankinglogin.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.bankinglogin.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement login = $("[data-test-id=login] input");
    private SelenideElement password = $("[data-test-id=password] input");
    private SelenideElement button = $("[data-test-id=action-login]");
    private SelenideElement error = $("[data-test-id=error-notification]");

    public VerificationPage loginValid (DataHelper.AuthInfo info) {
        login.setValue(info.getLogin());
        password.setValue((info.getPassword()));
        button.click();
        return new VerificationPage();
    }

    public void cleanStrings() {
        login.doubleClick().sendKeys(Keys.DELETE);
        password.doubleClick().sendKeys(Keys.DELETE);
    }

    public void getError() {
        error.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void getBlockError() {
        error.shouldHave(Condition.text("Вы ввели неверный пароль 3 раза. Возможность входа в личный кабинет заблокирована. Обратитесь в службу поддержки банка.")).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }
}

