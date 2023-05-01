package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {
    static final String URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    final static String ISSUE = "80";

    @Test
    public void testLambdaAttachmentStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(URL);
            attachment("Source", webdriver().driver().source());
        });

    }
    @Test
    public void testAnnotatedAttachmentStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage(URL);
        webSteps.takeScreenshot();

    }
}
