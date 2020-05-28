
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class StartUpTest {
    WebDriver driver;
    WebDriverWait wait;

    String menuLinkXpath = "//button[contains(@aria-label, 'Меню Страхование')]//span[contains(@class, 'lg-menu__text')]";
    String insuranceTravelLinkXpath = "//a[@href ='/ru/person/bank_inshure/insuranceprogram/life/travel']";
    String takeOutOnlineTravelInsuranceButtonXpath = "//b[@class='kit-button__text'][text()='Оформить онлайн']";
    String minSummInsuranceXpath = "//h3[@_ngcontent-c11][text()='Минимальная']";
    String sendButtonXpath = "//button[@class='btn btn-primary btn-large'][text()='Оформить']";
    String lastNameInsuredLatynXpath = "//input[@id='surname_vzr_ins_0']";
    String firstNameInsuredLatynXpath = "//input[@id='name_vzr_ins_0']";
    String birthdayInsuredXpath = "//input[@id='birthDate_vzr_ins_0']";
    String lastNamePolicyholderXpath = "//input[@id='person_lastName']";
    String firstNamePolicyholderXpath = "//input[@id='person_firstName']";
    String middleNamePolicyholderXpath = "//input[@id = 'person_middleName']";
    String birthdayPolicyholderXpath = "//input[@id ='person_birthDate']";
    String passportSeriesXpath = "//input[@id = 'passportSeries']";
    String passportNumberXpath = "//input[@id = 'passportNumber']";
    String passportDateXpath = "//input[@id = 'documentDate']";
    String passportIssuedByXpath = "//input[@id = 'documentIssue']";
    String continueButtonXpath = "//button[@class='btn btn-primary page__btn']";



    @BeforeEach
    public void Start ( ) {

        String browser = System.getProperty ( "browser" , "chrome" );
        switch ( browser ) {
            case "chrome": {
                System.setProperty ( "webdriver.chrome.driver" , "driver/chromedriver" );
                DesiredCapabilities capabilities = new DesiredCapabilities ( );
                capabilities.setCapability ( CapabilityType.PAGE_LOAD_STRATEGY , "eager" );
                driver = new ChromeDriver ( capabilities );
                break;
            }
            case "firefox": {
                System.setProperty ( "webdriver.gecko.driver" , "driver/geckodriver" );
                DesiredCapabilities capabilities = new DesiredCapabilities ( );
                capabilities.setCapability ( CapabilityType.PAGE_LOAD_STRATEGY , "eager" );
                driver = new FirefoxDriver ( capabilities );
            }
        }

            driver.manage ( ).window ( ).maximize ( );
            driver.manage ( ).timeouts ( ).pageLoadTimeout ( 20 , SECONDS );
            wait = new WebDriverWait ( driver , 20 );
        }

        public void findElement (String xPath ){
            driver.findElement ( By.xpath ( xPath ) );
    }

        public void findElementAndClick (String xPath ){
            driver.findElement ( By.xpath ( xPath ) ).click ( );
        }

        public void sendKeyText (String xPath , String value ){
            driver.findElement ( By.xpath ( xPath ) ).sendKeys ( value );
        }

        public void waitElementToBeClickable (String xPath ){
            new WebDriverWait ( driver , 20 ).until ( ExpectedConditions.elementToBeClickable ( By.xpath ( xPath ) ) );
        }

        public void waitVisibilityOfElementLocated (String xPath ){
            wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.xpath ( xPath ) ) );
        }
        public void waitPresenceOfElementLocated (String xPath){
            wait.until ( ExpectedConditions.presenceOfElementLocated ( By.xpath ( xPath ) ) );
        }


        @AfterEach
        public void tearDown () {
            driver.quit ( );
        }
    }




