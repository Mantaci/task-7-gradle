package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import utility.UIProps;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static utility.Urls.CHECKBOXES;

public class CheckboxesPage {

    UIProps props = ConfigFactory.create(UIProps.class);

    ElementsCollection checkboxes = $$x("//input");

@Step("Нажать на чекбокс {i}")
public void checkboxClick(int i){
    checkboxes.get(i).click();
}

@Step("Получить чекбокс {i}")
public SelenideElement getCheckBox(int i){
    return checkboxes.get(i);
}

@Step ("Открыть страницу чекбоксов")
public CheckboxesPage openCheckboxes(){
    open(props.baseURL()+CHECKBOXES);
    return this;
}

public boolean isCheckedBeforeClick(int i) {
    return getCheckBox(i).isSelected();
}


}
