import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SrbSeleniumTest extends StartUpTest {

@Parameterized.Parameters
    public static Collection <Object[]> data ( ) {

        Object[] one = {"Ivanov" , "Ivan" , "23.01.1988" , "Иванов" , "Иван" , "Иванович" , "24.01.1989" , "1111" , "111111" , "24.01.2018" , "УВД Москвы"};
        Object[] two = {"Petrov" , "Petr" , "23.04.1987" , "Петров" , "Петр" , "Петрович" , "25.08.1986" , "2222" , "222222" , "24.01.2019" , "УВД Волгоград"};
        Object[] three = {"Sergeev" , "Sergey" , "13.12.1987" , "Сергеев" , "Сергей" , "Сергеевич" , "10.10.1986" , "3333" , "333333" , "10.10.2006" , "Кировский УВД"};
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

    @Test

    public void insuranceOnlineTest ( ) {
        driver.get ( "http://www.sberbank.ru/ru/person" );
        //Переход во вкладку "Страхование"
        waitElementToBeClickable ( menuLinkXpath );
        findElementAndClick ( menuLinkXpath );

        //Переход на страницу "Страхование путешественников"
        waitElementToBeClickable ( insuranceTravelLinkXpath );
        findElementAndClick ( insuranceTravelLinkXpath );



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
        sendKeyText ( lastNameInsuredLatynXpath, lastNameInsured );

        //Заполнение поля "Name" в разделе "Застрахованные"
        findElementAndClick(firstNameInsuredLatynXpath);
        sendKeyText ( firstNameInsuredLatynXpath, firstNameInsured );

        //Заполнение поля "Дата рождения" в разделе "Застрахованные"
        findElementAndClick(birthdayInsuredXpath);
        sendKeyText ( birthdayInsuredXpath, birthdayInsured );

        //Заполнение поля "Фамилия" в разделе "Страхователь"
        findElementAndClick(lastNamePolicyholderXpath);
        sendKeyText ( lastNamePolicyholderXpath, lastNamePolicyholder);

        //Заполнение поля "Имя" в разделе "Страхователь"
        findElementAndClick(firstNamePolicyholderXpath);
        sendKeyText ( firstNamePolicyholderXpath, firstNamePolicyholder );

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
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", lastNameInsured,
                driver.findElement ( By.xpath (lastNameInsuredLatynXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", firstNameInsured,
                driver.findElement ( By.xpath (firstNameInsuredLatynXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", birthdayInsured,
                driver.findElement ( By.xpath (birthdayInsuredXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", lastNamePolicyholder,
                driver.findElement ( By.xpath (lastNamePolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", firstNamePolicyholder,
                driver.findElement ( By.xpath (firstNamePolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", middleNamePolicyholder,
                driver.findElement ( By.xpath (middleNamePolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", birthdayPolicyholder,
                driver.findElement ( By.xpath (birthdayPolicyholderXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", passportSeries,
                driver.findElement ( By.xpath (passportSeriesXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", passportNumber,
                driver.findElement ( By.xpath (passportNumberXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", passportDate,
                driver.findElement ( By.xpath (passportDateXpath) ).getAttribute("value"));
        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", passportIssuedBy,
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