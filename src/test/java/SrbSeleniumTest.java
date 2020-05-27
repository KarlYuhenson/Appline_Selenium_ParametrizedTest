import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SrbSeleniumTest extends StartUpTest {


    @Test
    @DisplayName ( "Проверка оформления страховки путещественников" )

    public void insuranceOnlineTest ( ) {
        driver.get ( "http://www.sberbank.ru/ru/person" );
        waitElementToBeClickable ( menuLinkXpath );
        //Переход во вкладку "Страхование"
        findElementAndClick ( menuLinkXpath );
        waitElementToBeClickable ( insuranceTravelLinkXpath );
        //Переход на страницу "Страхование путешественников"
        findElementAndClick ( insuranceTravelLinkXpath );
        waitElementToBeClickable ( takeOutOnlineTravelInsuranceButtonXpath );
        //Нажатие кнопки "Оформить онлайн"
        findElementAndClick ( takeOutOnlineTravelInsuranceButtonXpath );
        waitElementToBeClickable ( minSummInsuranceXpath );
        //Выбор минимальной суммы страховой защиты
        findElementAndClick ( minSummInsuranceXpath );
        waitElementToBeClickable ( sendButtonXpath );
        //Нажатие кнопки "Оформить"
        findElementAndClick ( sendButtonXpath );
        waitVisibilityOfElementLocated (lastNameInsuredLatynXpath);
        //Заполнение поля "Surname" в разделе "Застрахованные"
        findElementAndClick ( lastNameInsuredLatynXpath );
        sendKeyText ( lastNameInsuredLatynXpath, "Ivan" );
        //Заполнение поля "Name" в разделе "Застрахованные"
        findElementAndClick(firstNameInsuredLatynXpath);
        sendKeyText ( firstNameInsuredLatynXpath, "Ivanov" );
        //Заполнение поля "Дата рождения" в разделе "Застрахованные"
        findElementAndClick(birthdayInsuredXpath);
        sendKeyText ( birthdayInsuredXpath, "23011988" );
        //Заполнение поля "Фамилия" в разделе "Страхователь"
        findElementAndClick(lastNamePolicyholderXpath);
        sendKeyText ( lastNamePolicyholderXpath, "Иванов");
        //Заполнение поля "Имя" в разделе "Страхователь"
        findElementAndClick(firstNamePolicyholderXpath);
        sendKeyText ( firstNamePolicyholderXpath, "Иван" );
        //Заполнение поля "Отчество" в разделе "Страхователь"
        findElementAndClick ( middleNamePolicyholderXpath );
        sendKeyText ( middleNamePolicyholderXpath, "Иванович" );
        //Заполнение поля "Отчество" в разделе "Дата рождения"
        findElementAndClick ( birthdayPolicyholderXpath);
        sendKeyText ( birthdayPolicyholderXpath, "23011988" );
        //Заполнение поля "Серия" в разделе "Паспортные данные"
        findElementAndClick (passportSeriesXpath);
        sendKeyText (passportSeriesXpath, "1111");
        //Заполнение поля "Номер" в разделе "Паспортные данные"
        findElementAndClick (passportNumberXpath);
        sendKeyText (passportNumberXpath, "111111");
        //Заполнение поля "Дата выдачи" в разделе "Паспортные данные"
        findElementAndClick (passportDateXpath);
        sendKeyText (passportDateXpath, "08082014");
        //Заполнение поля "Кем выдан" в разделе "Паспортные данные"
        findElementAndClick (passportIssuedByXpath);
        sendKeyText (passportIssuedByXpath, "ОВД города Москвы");
        //Нажатие кнопки "Продолжить"
        waitPresenceOfElementLocated ( continueButtonXpath );
        findElementAndClick (continueButtonXpath);











    }

}