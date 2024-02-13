package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.get(loginPage.loginPageURL);
        loginPage.usernameField.click();
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
        homePage.cartButton.click();
    }

    @Test(priority = 10)
    public void VerifyThatCartIsEmptyUponLogin (){
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
    }
    @Test(priority = 20)
    public void userCanAddItemToCart (){
        driver.navigate().back();
        homePage.addBackpack.click();
        homePage.cartButton.click();
        Assert.assertTrue(cartPage.cartItem.isDisplayed());
    }
    @Test(priority = 20)
    public void userCanClickContinueShopping (){
        cartPage.continueShopping.click();
    }
    @Test(priority = 30)
    public void userCanClickCheckoutButton (){
        cartPage.checkoutButton.click();
    }
    @Test(priority = 40)
    public void userCanRemoveItemFromCart (){
        driver.navigate().back();
        homePage.addBackpack.click();
        homePage.cartButton.click();
        cartPage.removeBackpackFromCart.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.backpack));
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
    }
    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
