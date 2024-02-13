package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage.usernameField.click();
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
        homePage.cartButton.click();
    }

    @Test(priority = 10)
    public void cartIsEmpty (){
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));

    }





}
