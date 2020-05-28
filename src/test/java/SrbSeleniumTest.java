import org.junit.Assert;
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
        sendKeyText ( birthdayInsuredXpath, "23.01.1988" );
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
        sendKeyText ( birthdayPolicyholderXpath, "23.01.1988" );
        //Заполнение поля "Серия" в разделе "Паспортные данные"
        findElementAndClick (passportSeriesXpath);
        sendKeyText (passportSeriesXpath, "1111");
        //Заполнение поля "Номер" в разделе "Паспортные данные"
        findElementAndClick (passportNumberXpath);
        sendKeyText (passportNumberXpath, "111111");
        //Заполнение поля "Дата выдачи" в разделе "Паспортные данные"
        findElementAndClick (passportDateXpath);
        sendKeyText (passportDateXpath, "08.08.2014");
        //Заполнение поля "Кем выдан" в разделе "Паспортные данные"
        findElementAndClick (passportIssuedByXpath);
        sendKeyText (passportIssuedByXpath, "ОВД города Москвы");

        //Проверка заполнения полей
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Ivan",
                driver.findElement ( By.xpath (lastNameInsuredLatynXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Ivanov",
                driver.findElement ( By.xpath (firstNameInsuredLatynXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "23.01.1988",
                driver.findElement ( By.xpath (birthdayInsuredXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Иванов",
                driver.findElement ( By.xpath (lastNamePolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Иван",
                driver.findElement ( By.xpath (firstNamePolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Иванович",
                driver.findElement ( By.xpath (middleNamePolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "23.01.1988",
                driver.findElement ( By.xpath (birthdayPolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "1111",
                driver.findElement ( By.xpath (passportSeriesXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "111111",
                driver.findElement ( By.xpath (passportNumberXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "08.08.2014",
                driver.findElement ( By.xpath (passportDateXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "ОВД города Москвы",
                driver.findElement ( By.xpath (passportIssuedByXpath) ).getAttribute("value"));


        //Нажатие кнопки "Продолжить"
        waitPresenceOfElementLocated ( continueButtonXpath );
        findElementAndClick (continueButtonXpath);

        //Проверка ошибки
        waitPresenceOfElementLocated ( "//div[@class='alert-form alert-form-error']" );
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "При заполнении данных произошла ошибка",
                driver.findElement ( By.xpath ( "//div[@class='alert-form alert-form-error']" ) ).getText () );












    }

}