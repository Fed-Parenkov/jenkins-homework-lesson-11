package parenkov.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindow {

    public void checkModalWindow(String modalTitle, String studentName, String email, String gender,
                                 String mobileNumber, String dateOfBirth, String subject, String hobbies,
                                 String picture, String address, String stateAndCity) {
        $("#example-modal-sizes-title-lg").shouldHave(text(modalTitle));
        $(".modal-body").shouldHave(text(studentName), text(email), text(gender), text(mobileNumber),
                text(dateOfBirth), text(subject), text(hobbies), text(picture), text(address), text(stateAndCity));
    }
}
