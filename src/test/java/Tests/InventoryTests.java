package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class InventoryTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.get(loginPage.loginPageURL);
        loginPage.usernameField.click();
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
    }

    @Test(priority = 10)
    public void userCanAddBackpackToCart(){
        homePage.addBackpack.click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"1");
        homePage.cartButton.click();
        Assert.assertEquals(homePage.backpack.getText(),"Sauce Labs Backpack");
    }
    @Test(priority = 11)
    public void userCanAddJacketToCart(){
        homePage.addJacket.click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"1");
        homePage.cartButton.click();
        Assert.assertEquals(homePage.jacket.getText(),"Sauce Labs Fleece Jacket");
    }
    @Test(priority = 12)
    public void userCanAddOnesieToCart(){
        homePage.addOnesie.click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"1");
        homePage.cartButton.click();
        Assert.assertEquals(homePage.onesie.getText(),"Sauce Labs Onesie");
    }
    @Test(priority = 13)
    public void userCanAddBikeLightToCart(){
        homePage.addBikeLight.click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"1");
        homePage.cartButton.click();
        Assert.assertEquals(homePage.bikeLight.getText(),"Sauce Labs Bike Light");
    }
    @Test(priority = 14)
    public void userCanAddTShirtToCart(){
        homePage.addTShirt.click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"1");
        homePage.cartButton.click();
        Assert.assertEquals(homePage.tShirt.getText(),"Sauce Labs Bolt T-Shirt");
    }
    @Test(priority = 15)
    public void userCanAddRedTShirtToCart(){
        homePage.addRedTShirt.click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"1");
        homePage.cartButton.click();
        Assert.assertEquals(homePage.redTShirt.getText(),"Test.allTheThings() T-Shirt (Red)");
    }
    @Test(priority = 20)
    public void userCanRemoveItemsFromCartOnHomePage(){
        homePage.addBackpack.click();
        homePage.removeBackpack.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.cartNotification));
        homePage.cartButton.click();
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
        driver.navigate().back();

        homePage.addJacket.click();
        homePage.removeJacket.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.cartNotification));
        homePage.cartButton.click();
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
        driver.navigate().back();

        homePage.addOnesie.click();
        homePage.removeOnesie.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.cartNotification));
        homePage.cartButton.click();
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
        driver.navigate().back();

        homePage.addBikeLight.click();
        homePage.removeBikeLight.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.cartNotification));
        homePage.cartButton.click();
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
        driver.navigate().back();

        homePage.addTShirt.click();
        homePage.removeTShirt.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.cartNotification));
        homePage.cartButton.click();
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
        driver.navigate().back();

        homePage.addRedTShirt.click();
        homePage.removeRedTShirt.click();
        Assert.assertFalse(homePage.elementDisplayed(homePage.cartNotification));
        homePage.cartButton.click();
        Assert.assertFalse(homePage.elementDisplayed(cartPage.cartItem));
    }
    @Test(priority = 30 )
    public void userCanClickOnItems(){
        homePage.backpack.click();
        driver.navigate().back();
        homePage.bikeLight.click();
        driver.navigate().back();
        homePage.tShirt.click();
        driver.navigate().back();
        homePage.redTShirt.click();
        driver.navigate().back();
        homePage.onesie.click();
        driver.navigate().back();
        homePage.jacket.click();
    }
    @Test(priority = 40)
    public void userCanSortItems() throws InterruptedException {
        homePage.filterButton.click();
        homePage.aToZ.click();
        homePage.filterButton.click();
        homePage.zToA.click();
        homePage.filterButton.click();
        homePage.lowToHigh.click();
        homePage.filterButton.click();
        homePage.highToLow.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
