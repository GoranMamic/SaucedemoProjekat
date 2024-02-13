package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.get(loginPage.loginPageURL);
    }
    @Test(priority = 10)
    public void userCanLoginWithValidCredentials() {
        loginPage.usernameField.click();
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),homePage.homepageURL);
        Assert.assertTrue(homePage.pageLogo.isDisplayed());
    }
    @Test(priority = 20)
    public void userCantLoginWithInvalidPassword(){
        for (int i = 1; i <= excelReader.getLastRow("LoginCredentials"); i++) {
            String validUsernameData = excelReader.getStringData("LoginCredentials", i, 0);
            String invalidPasswordData = excelReader.getStringData("LoginCredentials", i, 3);
            loginPage.inputUsername(validUsernameData);
            loginPage.inputPassword(invalidPasswordData);
            loginPage.loginButton.click();
            Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(),loginPage.loginPageURL);
        }
    }
    @Test(priority = 30)
    public void userCantLoginWithInvalidUsername() {
        for (int i = 1; i <= excelReader.getLastRow("LoginCredentials"); i++) {
            String invalidUsernameData = excelReader.getStringData("LoginCredentials", i, 1);
            String validPasswordData = excelReader.getStringData("LoginCredentials", 1, 2);
            loginPage.inputUsername(invalidUsernameData);
            loginPage.inputPassword(validPasswordData);
            loginPage.loginButton.click();
            Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), loginPage.loginPageURL);
        }
    }
    @Test(priority = 40)
    public void userCantLoginWithInvalidCredentials() {
        for (int i = 1; i <= excelReader.getLastRow("LoginCredentials"); i++) {
            String invalidUsernameData = excelReader.getStringData("LoginCredentials", i, 1);
            String invalidPasswordData = excelReader.getStringData("LoginCredentials", i, 3);
            loginPage.inputUsername(invalidUsernameData);
            loginPage.inputPassword(invalidPasswordData);
            loginPage.loginButton.click();
            Assert.assertTrue(checkoutPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), loginPage.loginPageURL);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
