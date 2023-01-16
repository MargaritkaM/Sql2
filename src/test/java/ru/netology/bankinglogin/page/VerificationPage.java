package ru.netology.bankinglogin.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement notification = $("[data-test-id=error-notification] div.notification__content");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public void inputData(String code){
        codeField.setValue(code);
        verifyButton.click();
    }

    public DashboardPage validVerify(String code) {
        inputData(code);
        return new DashboardPage();
    }

    public String inValidVerify(String code) {
        inputData(code);
        notification.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return notification.text();
    }
}