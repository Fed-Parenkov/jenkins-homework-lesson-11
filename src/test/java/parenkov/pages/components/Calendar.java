package parenkov.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    public void setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();

        String daySelector = "//div[@class='react-datepicker__day react-datepicker__day--0%s']";
        String setDay = String.format(daySelector, day);
        $(byXpath(setDay)).click();
    }
}
