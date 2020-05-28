import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
@RunWith( Parameterized.class )
public class SrbSeleniumTest extends StartUpTest {
    @Parameterized.Parameters
    public static Collection <Object[]> param ( ) {

        Object[] one = {"Ivanov" , "Ivan" , "23011988" , "Иванов" , "Иван" , "Иванович" , "24011989" , "1111" , "24021989" , "24012018" , "УВД Москвы"};
        Object[] two = {"Petrov" , "Petr" , "23041987" , "Петров" , "Петр" , "Петрович" , "25081986" , "2222" , "222222" , "24012019" , "УВД Волгоград"};
        Object[] three = {"Sergeev" , "Sergey" , "13121987" , "Сергеев" , "Сергей" , "Сергеевич" , "10101986" , "3333" , "333333" , "10102000" , "Кировский УВД"};
        return Arrays.asList ( one, two, three);

    }

    @Parameterized.Parameter(0)
    public String lastNameInsured;
    @Parameterized.Parameter(1)
    public  String firstNameInsured;
    @Parameterized.Parameter(2)
    public  String birthdayInsured;
    @Parameterized.Parameter(3)
    public  String lastNamePolicyholder;
    @Parameterized.Parameter(4)
    public  String firstNamePolicyholder;
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
    public  String passportIssuedBy;
    @Parameterized.Parameter(11)
    public  String continueButton;




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