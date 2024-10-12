package pages;

import com.codeborne.selenide.*;
import org.assertj.core.api.AbstractAssert;


public class InputsPageAssert extends AbstractAssert<InputsPageAssert, InputsPage> {

    public InputsPageAssert(InputsPage actual) {
        super(actual, InputsPageAssert.class);
    }
    public static InputsPageAssert assertThat(InputsPage actual) {
        return new InputsPageAssert(actual);
    }

    public InputsPageAssert inputShouldHaveValue(String value) {

        actual.input.shouldHave(Condition.value(value));
        return this;
    }



}
