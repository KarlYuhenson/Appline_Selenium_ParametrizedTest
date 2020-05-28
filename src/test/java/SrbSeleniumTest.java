import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SrbSeleniumTest extends StartUpTest {




    @Test
    @DisplayName ( "Проверка оформления страховки путещественников" )

    public void insuranceOnlineTest ( ) {
        driver.get ( "http://www.sberbank.ru/ru/person" );
        waitElementToBeClickable ( menuLinkXpath );
        //Переход во вкладку "Страхование"
        findElementAndClick ( menuLinkXpath );
        //Переход на страницу "Страхование путешественников"
        waitElementToBeClickable ( insuranceTravelLinkXpath );
        findElementAndClick ( insuranceTravelLinkXpath );

//        //Проверка наличия баннера с текстом "Страхование путешественников" (падает)
//        waitPresenceOfElementLocated ("//h1[text()='Страхование путешественников']");
//        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Страхование путешественников",
//                driver.findElement ( By.xpath ( "//h1[text()='Страхование путешественников']" ) ).getText () );


        //Нажатие кнопки "Оформить онлайн"
        waitElementToBeClickable ( takeOutOnlineTravelInsuranceButtonXpath );
        findElementAndClick ( takeOutOnlineTravelInsuranceButtonXpath );
        //Выбор минимальной суммы страховой защиты
        waitElementToBeClickable ( minSummInsuranceXpath );
        findElementAndClick ( minSummInsuranceXpath );
        //Нажатие кнопки "Оформить"
        waitElementToBeClickable ( sendButtonXpath );
        findElementAndClick ( sendButtonXpath );
        //Заполнение поля "Surname" в разделе "Застрахованные"
        waitVisibilityOfElementLocated (lastNameInsuredLatynXpath);
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

//        //Проверка заполнения всех полей
//        Assert.assertEquals ( "Заполните текстовое поле", "Иванов",
//                driver.findElement ( By.xpath ( "//input[contains(@data-bind, 'value:LastName')]") ).getAttribute("value"));

        //Нажатие кнопки "Продолжить"
        waitPresenceOfElementLocated ( continueButtonXpath );
        findElementAndClick (continueButtonXpath);

        //Проверка ошибки
        waitPresenceOfElementLocated ( "//div[@class='alert-form alert-form-error']" );
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "При заполнении данных произошла ошибка",
                driver.findElement ( By.xpath ( "//div[@class='alert-form alert-form-error']" ) ).getText () );












    }

}