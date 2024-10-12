package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import utility.UIProps;

import static com.codeborne.selenide.Selenide.*;
import static utility.Urls.DROPDOWN;

public class DropdownPage {

    UIProps props = ConfigFactory.create(UIProps.class);

    ElementsCollection dropdownOptions = $$x("//select/option[1]/following-sibling::*");
    SelenideElement dropdownList = $x("//select");

    public DropdownPageAssert check(){
        return DropdownPageAssert.assertThat(this);
    }

    @Step("Открыть страницу Dropdown")
    public DropdownPage openDropdownPage() {
        open(props.baseURL()+DROPDOWN);
        return this;
    }
    @Step("Кликнуть по элементу DropdownList")
    public DropdownPage dropdownListClick(){
        dropdownList.click();
        return this;
    }
    @Step("Кликнуть по опции из DropdownList")
    public void selectOption(SelenideElement option) {
        option.click();
    }
    @Step("Вернуть значение опций из DropdownList")
    public ElementsCollection getDropdownOptions() {
        return dropdownOptions;
    }



}
