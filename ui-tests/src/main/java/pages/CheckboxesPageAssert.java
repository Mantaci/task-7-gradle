package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.*;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.attribute;

public class CheckboxesPageAssert extends AbstractAssert<CheckboxesPageAssert, CheckboxesPage> {

public CheckboxesPageAssert(CheckboxesPage actual) {
    super(actual, CheckboxesPageAssert.class);
}
    public CheckboxesPageAssert assertThat (CheckboxesPage actual) {
        return new CheckboxesPageAssert(actual);
    }

public CheckboxesPageAssert isCheckboxChecked(int i) {
    actual.getCheckBox(i).shouldBe(Condition.checked);
    return this;
}

public CheckboxesPageAssert isCheckboxNotChecked(int i) {
    actual.getCheckBox(i).shouldNotBe(Condition.checked);
    return this;
}


}


