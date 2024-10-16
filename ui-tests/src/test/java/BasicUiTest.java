import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.CheckboxesPage;
import pages.DisappearingElementsPage;
import pages.DropdownPage;
import pages.InputsPage;
import utility.UIProps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasicUiTest {

    CheckboxesPage checkboxesPage;
    DropdownPage dropdownPage;
    DisappearingElementsPage disappearingElementsPage;
    InputsPage inputsPage;

    UIProps props = ConfigFactory.create(UIProps.class);



    @BeforeEach
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        checkboxesPage = new CheckboxesPage();
        dropdownPage = new DropdownPage();
        disappearingElementsPage = new DisappearingElementsPage();
        inputsPage = new InputsPage();



        //DesiredCapabilities caps = new DesiredCapabilities(props.webDriverBrowserName(), props.webDriverBrowserVersion(), Platform.LINUX);
        //Configuration.remote = props.webDriverURL();
        //Configuration.browserCapabilities = caps;
    }

    @AfterEach
    public void tearDown() {
        getWebDriver().quit();
    }

}
