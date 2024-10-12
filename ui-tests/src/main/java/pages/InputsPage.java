package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import utility.UIProps;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static utility.Urls.INPUTS;

public class InputsPage {

    UIProps props = ConfigFactory.create(UIProps.class);
    SelenideElement input = $x("//input");


    public InputsPageAssert check(){
        return InputsPageAssert.assertThat(this);
    }

    @Step("Открыть страницу input")
public InputsPage openInputsPage(){
        open(props.baseURL()+INPUTS);
        return this;
}

@Step("Кликнуть по элементу input")
public InputsPage inputElementClick(){
        input.click();
        return this;
}

@Step ("Ввести значение {value} в input")
public InputsPage inputElementSendKeys(String value){
input.sendKeys(value);
return this;
}

@Step ("Получить элемент input")
public String inputElementGetValue(){
        return input.getValue();
}



}
