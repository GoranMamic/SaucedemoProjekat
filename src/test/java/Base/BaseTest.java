package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseTest {

    public ExcelReader excelReader;
    public static WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutPageStep2 checkoutPageStep2;
    public CheckoutCompletePage checkoutCompletePage;




    @BeforeMethod
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        checkoutPageStep2 = new CheckoutPageStep2();
        checkoutCompletePage = new CheckoutCompletePage();
        excelReader = new ExcelReader("CredentialsTest.xlsx");

    }

    }
