package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.Option;
import java.util.ArrayList;

public class HomePage extends BaseTest {
    public HomePage() {{PageFactory.initElements(driver, this);}}

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement addOnesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement addRedTShirt;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpack;
    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement removeBikeLight;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeTShirt;
    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    public WebElement removeJacket;
    @FindBy(id = "remove-sauce-labs-onesie")
    public WebElement removeOnesie;
    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement removeRedTShirt;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartNotification;

    @FindBy(className = "product_sort_container")
    public WebElement filterButton;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[1]")
    public WebElement aToZ;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[2]")
    public WebElement zToA;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]")
    public WebElement lowToHigh;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[4]")
    public WebElement highToLow;
    @FindBy(linkText = "Sauce Labs Backpack")
    public WebElement backpack;
    @FindBy(linkText = "Sauce Labs Bike Light")
    public WebElement bikeLight;
    @FindBy(linkText = "Sauce Labs Bolt T-Shirt")
    public WebElement tShirt;
    @FindBy(linkText = "Sauce Labs Onesie")
    public WebElement onesie;
    @FindBy(linkText = "Test.allTheThings() T-Shirt (Red)")
    public WebElement redTShirt;
    @FindBy(linkText = "Sauce Labs Fleece Jacket")
    public WebElement jacket;
    @FindBy(className = "app_logo")
    public WebElement pageLogo;
    public String homepageURL = "https://www.saucedemo.com/inventory.html";






    //-------------------------------------------//


    public boolean elementDisplayed(WebElement celement) {
        boolean isDisplayed = false;
        try {
            isDisplayed = celement.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isDisplayed;
    }



}



