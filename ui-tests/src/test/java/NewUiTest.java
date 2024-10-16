import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class NewUiTest extends BasicUiTest {

    @ParameterizedTest
    @MethodSource("checkboxOrderProvider")
    public void checkboxesTest(int[] checkboxOrder) {


        CheckboxesPageAssert checkboxesPageAssert = new CheckboxesPageAssert(checkboxesPage);


        checkboxesPage.openCheckboxes();
        for (int index : checkboxOrder) {
            boolean isCheckedBeforeClick = checkboxesPage.isCheckedBeforeClick(index);
            checkboxesPage.checkboxClick(index);

            if (isCheckedBeforeClick) {
                checkboxesPageAssert.isCheckboxNotChecked(index);
            } else {
                checkboxesPageAssert.isCheckboxChecked(index);
            }

            System.out.println("Checkbox " + index + " checked attribute: " + checkboxesPage.getCheckBox(index).isSelected());
        }
    }

    private static int[][] checkboxOrderProvider() {
        return new int[][]{
                {0, 1},
                {1, 0}
        };
    }


    @Test
    public void dropdownTest() {
        ElementsCollection dropdownOptions = dropdownPage.getDropdownOptions();


        dropdownPage.openDropdownPage().dropdownListClick();

        for (SelenideElement option : dropdownOptions) {
            dropdownPage.selectOption(option);
            dropdownPage.check().assertOptionIsSelected(option);
            dropdownPage.dropdownListClick();
        }



}

    @RepeatedTest(5)
    public void disappearingElementsTest() {
        int maxAttempts = 10;

        disappearingElementsPage.openDisappearingElementsPage();

        for (int i = 0; i < maxAttempts; i++) {
            if (disappearingElementsPage.check().isSizeNot(5)) {
                refresh();
            }
            else break;
        }
        disappearingElementsPage.check().sizeIs(5);

    }


    @TestFactory
    List<DynamicTest> inputFactoryTests(){
        List<DynamicTest> inputDynamicTests = new ArrayList<>();

        String[] inputValues = {"12345", "0000000", "-789", "999999", "5.6", "asdasdasd", "=///::", "абв", " 22", "33 "};
        for (String value : inputValues) {
            inputDynamicTests.add(DynamicTest.dynamicTest("Testing value:" + value, () -> inputsTest(value)));
        }
        return inputDynamicTests;
    }

    public void inputsTest(String inputValue) {


        inputsPage.openInputsPage().inputElementClick().inputElementSendKeys(inputValue);
        String actualInputValue = inputsPage.inputElementGetValue();

        System.out.println("Value:"+actualInputValue);

        inputsPage.check().inputShouldHaveValue(inputValue);
        Assertions.assertEquals(inputValue, actualInputValue);



    }


}
