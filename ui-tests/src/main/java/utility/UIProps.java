package utility;
import org.aeonbits.owner.*;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/config.properties"
})

public interface UIProps extends Config{

    @Key("BASE_URL")
    String baseURL();

    @Key("selenoid.webDriver.url")
    String webDriverURL();

    @Key("selenoid.webDriver.browserName")
    String webDriverBrowserName();

    @Key("selenoid.webDriver.browserVersion")
    String webDriverBrowserVersion();

}
