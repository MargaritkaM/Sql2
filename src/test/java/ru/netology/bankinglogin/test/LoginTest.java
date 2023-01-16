package ru.netology.bankinglogin.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.bankinglogin.data.DataHelper;
import ru.netology.bankinglogin.data.SqlHelper;
import ru.netology.bankinglogin.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static java.awt.SystemColor.info;
import static ru.netology.bankinglogin.data.SqlHelper.cleanDatabase;

public class LoginTest {

//        @BeforeEach
//        void setup() {
//            Configuration.holdBrowserOpen = true;
//            open("http://localhost:9999");
//        }

    @AfterAll
    static void tearDown () {
        cleanDatabase();
    }
    @org.junit.jupiter.api.Test
    public void shouldLogin() {
            var loginPage = open("http://localhost:9999",LoginPage.class);
            var authInfo = DataHelper.getAuthInfoWithTestData();
            var verificationPage = loginPage.loginValid(authInfo);
            var verificationCode = SqlHelper.getVerificationCode();
            verificationPage.validVerify(verificationCode.getCode());
        }
}


