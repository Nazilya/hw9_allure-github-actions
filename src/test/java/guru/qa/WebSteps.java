package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Ищем репозитрий {repo}")
    public void searchRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void openRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Переходим на вкладку Issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void checkIssueByName(String issue) {
        $(withText(issue)).should(Condition.visible);
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
