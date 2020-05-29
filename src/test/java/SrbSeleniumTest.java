import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SrbSeleniumTest extends StartUpTest {



    @DisplayName ( "Проверка оформления страховки путещественников" )
    @Parameterized.Parameters
    public static Collection <Object[]> data ( ) {

        Object[] one = {"Ivanov" , "Ivan" , "23011988" , "Иванов" , "Иван" , "Иванович" , "24011989" , "1111" , "24021989" , "24012018" , "УВД Москвы"};
        Object[] two = {"Petrov" , "Petr" , "23041987" , "Петров" , "Петр" , "Петрович" , "25081986" , "2222" , "222222" , "24012019" , "УВД Волгоград"};
        Object[] three = {"Sergeev" , "Sergey" , "13121987" , "Сергеев" , "Сергей" , "Сергеевич" , "10101986" , "3333" , "333333" , "10102000" , "Кировский УВД"};
        return Arrays.asList ( one , two , three );
    }

    @Parameterized.Parameter
    public  String lastNameInsured;
    @Parameterized.Parameter(1)
    public   String firstNameInsured;
    @Parameterized.Parameter(2)
    public   String birthdayInsured;
    @Parameterized.Parameter(3)
    public   String lastNamePolicyholder;
    @Parameterized.Parameter(4)
    public   String firstNamePolicyholder;
    @Parameterized.Parameter(5)
    public  String middleNamePolicyholder;
    @Parameterized.Parameter(6)
    public  String birthdayPolicyholder;
    @Parameterized.Parameter(7)
    public  String passportSeries;
    @Parameterized.Parameter(8)
    public  String passportNumber;
    @Parameterized.Parameter(9)
    public  String passportDate;
    @Parameterized.Parameter(10)
    public   String passportIssuedBy;

    @ParameterizedTest
    @MethodSource("data")
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
        sendKeyText ( lastNameInsuredLatynXpath, lastNameInsured );
        //Заполнение поля "Name" в разделе "Застрахованные"
        findElementAndClick(firstNameInsuredLatynXpath);
        sendKeyText ( firstNameInsuredLatynXpath, lastNameInsured );
        //Заполнение поля "Дата рождения" в разделе "Застрахованные"
        findElementAndClick(birthdayInsuredXpath);
        sendKeyText ( birthdayInsuredXpath, firstNameInsured );
        //Заполнение поля "Фамилия" в разделе "Страхователь"
        findElementAndClick(lastNamePolicyholderXpath);
        sendKeyText ( lastNamePolicyholderXpath, birthdayInsured);
        //Заполнение поля "Имя" в разделе "Страхователь"
        findElementAndClick(firstNamePolicyholderXpath);
        sendKeyText ( firstNamePolicyholderXpath, lastNamePolicyholder );
        //Заполнение поля "Отчество" в разделе "Страхователь"
        findElementAndClick ( middleNamePolicyholderXpath );
        sendKeyText ( middleNamePolicyholderXpath, middleNamePolicyholder );
        //Заполнение поля "Отчество" в разделе "Дата рождения"
        findElementAndClick ( birthdayPolicyholderXpath);
        sendKeyText ( birthdayPolicyholderXpath, birthdayPolicyholder );
        //Заполнение поля "Серия" в разделе "Паспортные данные"
        findElementAndClick (passportSeriesXpath);
        sendKeyText (passportSeriesXpath, passportSeries);
        //Заполнение поля "Номер" в разделе "Паспортные данные"
        findElementAndClick (passportNumberXpath);
        sendKeyText (passportNumberXpath, passportNumber);
        //Заполнение поля "Дата выдачи" в разделе "Паспортные данные"
        findElementAndClick (passportDateXpath);
        sendKeyText (passportDateXpath, passportDate);
        //Заполнение поля "Кем выдан" в разделе "Паспортные данные"
        findElementAndClick (passportIssuedByXpath);
        sendKeyText (passportIssuedByXpath, passportIssuedBy);

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