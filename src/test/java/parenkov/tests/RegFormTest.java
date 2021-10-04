package parenkov.tests;

import org.junit.jupiter.api.Test;
import parenkov.pages.RegFormPage;

import static io.qameta.allure.Allure.step;
import static parenkov.tests.TestData.*;

public class RegFormTest extends TestBase {

    RegFormPage regFormPage = new RegFormPage();

    @Test
    void FillRegFormTest() {

        step("Открыть страницу с формой на https://demoqa.com/", () -> {
            regFormPage.openPage();
        });
        step("Ввести First Name", () -> {
            regFormPage.typeFirstName();
        });
        step("Ввести Last Name", () -> {
            regFormPage.typeLastName();
        });
        step("Ввести Email", () -> {
            regFormPage.typeEmail();
        });
        step("Выбрать пол", () -> {
            regFormPage.selectGender(gender);
        });
        step("Ввести мобильный номер", () -> {
            regFormPage.typeMobileNumber();
        });
        step("Выбрать Subject", () -> {
            regFormPage.typeSubject(subject);
        });
        step("Выбрать хобби", () -> {
            regFormPage.selectHobbies(hobbies);
        });
        step("Загрузить картинку", () -> {
            regFormPage.uploadPicture();
        });
        step("Установить дату рождения", () -> {
            regFormPage.calendar.setDateOfBirth(day, month, year);
        });
        step("Скролл страницы вниз", () -> {
            regFormPage.scrollPage();
        });
        step("Ввести Current Address", () -> {
            regFormPage.typeCurrentAddress();
        });
        step("Ввести State", () -> {
            regFormPage.typeState();
        });
        step("Ввести City", () -> {
            regFormPage.typeCity();
        });
        step("Нажать кнопку Submit", () -> {
            regFormPage.clickSubmit();
        });
        step("Проверить соответствие введенных данных в модальном окне", () -> {
            regFormPage.checkModalWindow();
        });
    }
}
