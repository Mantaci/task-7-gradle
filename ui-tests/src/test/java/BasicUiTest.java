import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.CheckboxesPage;
import utility.UIProps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasicUiTest {

    CheckboxesPage checkboxesPage;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        checkboxesPage = new CheckboxesPage();
    }

    @AfterEach
    public void tearDown() {
        getWebDriver().quit();
    }

}
