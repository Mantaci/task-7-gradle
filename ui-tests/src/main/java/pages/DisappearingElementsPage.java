package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import utility.UIProps;

import static com.codeborne.selenide.Selenide.*;
import static utility.Urls.DISAPPEARING_ELEMENTS;

public class DisappearingElementsPage {


    UIProps props = ConfigFactory.create(UIProps.class);
    ElementsCollection disappearingElements = $$x("//li");

    public DisappearingElementsPageAssert check(){
        return DisappearingElementsPageAssert.assertThat(this);
    }

    @Step("Открыть страницу DisappearingElements")
public DisappearingElementsPage openDisappearingElementsPage() {
    open(props.baseURL()+DISAPPEARING_ELEMENTS);
    return this;
}


}
