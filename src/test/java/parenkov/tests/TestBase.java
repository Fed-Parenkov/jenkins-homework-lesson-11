package parenkov.tests;

import attachments.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;


public class TestBase {

    // передаем креды для selenoid из файла .properties
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setup() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;

        String url = System.getProperty("url");

        // передаем креды для selenoid из jenkins в виде системных переменных
//        String login = System.getProperty("login");
//        String password = System.getProperty("password");

        // передаем креды для selenoid из файла .properties
        String login = credentials.login();
        String password = credentials.password();

//        String remote = format("https://%s:%s@%s", login, password, url);
        String remote = "https://" + login + ":" + password + "@" + url;
//        String remote = "https://" + login + ":" + password + "@" + url;
        System.out.println(remote);
        Configuration.remote = remote;
    }

    @AfterEach
    public void attachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
