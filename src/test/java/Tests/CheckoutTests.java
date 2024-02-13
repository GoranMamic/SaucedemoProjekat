package Tests;

import Base.BaseTest;
import Base.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.get(loginPage.loginPageURL);
        loginPage.usernameField.click();
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
        homePage.addBackpack.click();
        homePage.cartButton.click();
        cartPage.checkoutButton.click();
    }
    @Test(priority = 10)
    public void userCanCancelCheckout(){
        checkoutPage.cancelButton.click();
    }
    @Test(priority = 20)
    public void userCanCheckoutWithValidCredentials() {
        for (int i = 1; i <= excelReader.getLastRow("CheckoutCredentials"); i++) {
            String firstNameData = excelReader.getStringData("CheckoutCredentials", i, 0);
            String lastNameData = excelReader.getStringData("CheckoutCredentials", i, 1);
            String postalCodeData = String.valueOf(excelReader.getIntegerData("CheckoutCredentials", i, 2));

            checkoutPage.inputFirstName(firstNameData);
            checkoutPage.inputLastName(lastNameData);
            checkoutPage.inputPostalCode(postalCodeData);
            checkoutPage.continueButton.click();

            Assert.assertEquals(driver.getCurrentUrl(), checkoutPageStep2.checkoutPageStep2URL);
            Assert.assertTrue(checkoutPageStep2.ChekoutOverview.isDisplayed());
            Assert.assertTrue(checkoutPageStep2.finishButton.isDisplayed());
            Assert.assertTrue(checkoutPageStep2.totalPrice.isDisplayed());
            driver.navigate().back();
        }
    }
    @Test(priority = 29)
    public void userCantProceedToCheckout2WithBlankFields(){
        checkoutPage.continueButton.click();
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),checkoutPage.checkoutPageURL);
    }

    @Test(priority = 30)
    public void userCantProceedToCheckout2WithoutFirstName(){
        checkoutPage.inputLastName("Smith");
        checkoutPage.inputPostalCode("11000");
        checkoutPage.continueButton.click();
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),checkoutPage.checkoutPageURL);
    }

    @Test(priority = 40)
    public void userCantProceedToCheckout2WithoutLastName(){
        checkoutPage.inputFirstName("Matt");
        checkoutPage.inputPostalCode("11000");
        checkoutPage.continueButton.click();
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),checkoutPage.checkoutPageURL);
    }

    @Test(priority = 50)
    public void userCantProceedToCheckout2WithoutPostalCode(){
        checkoutPage.inputFirstName("Matt");
        checkoutPage.inputLastName("Smith");
        checkoutPage.continueButton.click();
        Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),checkoutPage.checkoutPageURL);
    }
    @Test(priority = 60)
    public void userCanOrderProducts() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("CheckoutCredentials"); i++) {
            String firstNameData = excelReader.getStringData("CheckoutCredentials", i, 0);
            String lastNameData = excelReader.getStringData("CheckoutCredentials", i, 1);
            String postalCodeData = String.valueOf(excelReader.getIntegerData("CheckoutCredentials", i, 2));

            checkoutPage.inputFirstName(firstNameData);
            checkoutPage.inputLastName(lastNameData);
            checkoutPage.inputPostalCode(postalCodeData);
            checkoutPage.continueButton.click();
            checkoutPageStep2.finishButton.click();

            Assert.assertEquals(checkoutCompletePage.checkoutCompleteMessage.getText(), "Checkout: Complete!");
            Assert.assertEquals(checkoutCompletePage.thankYouMessage.getText(), "Thank you for your order!");

            checkoutCompletePage.backToHomeButton.click();
            homePage.addBackpack.click();
            homePage.cartButton.click();
            cartPage.checkoutButton.click();
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
