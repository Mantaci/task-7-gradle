package pages;

import com.codeborne.selenide.CollectionCondition;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Condition;


public class DisappearingElementsPageAssert extends AbstractAssert<DisappearingElementsPageAssert, DisappearingElementsPage> {


    public DisappearingElementsPageAssert(DisappearingElementsPage actual) {
        super(actual, DisappearingElementsPageAssert.class);
    }

    public static DisappearingElementsPageAssert assertThat(DisappearingElementsPage actual) {
        return new DisappearingElementsPageAssert(actual);
    }

    public boolean isSizeNot(int i) {
        return actual.disappearingElements.size() != i;
    }

public DisappearingElementsPageAssert sizeIs(int i) {
    actual.disappearingElements.should(CollectionCondition.size(i));
    return this;
}


}
