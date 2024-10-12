package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.*;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.attribute;

public class DropdownPageAssert extends AbstractAssert<DropdownPageAssert, DropdownPage> {

    public static DropdownPageAssert assertThat(DropdownPage actual) {
        return new DropdownPageAssert(actual);
    }

    public DropdownPageAssert(DropdownPage actual) {
        super(actual, DropdownPageAssert.class);
    }


    public void assertOptionIsSelected(SelenideElement option) {
        option.shouldBe(Condition.selected);
    }
}
