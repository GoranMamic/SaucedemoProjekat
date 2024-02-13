package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
    public CheckoutPage() {{PageFactory.initElements(driver, this);}}

    @FindBy(id = "cancel")
    public WebElement cancelButton;
    @FindBy(id = "continue")
    public WebElement continueButton;
    @FindBy(id = "first-name")
    public WebElement firstNameField;
    @FindBy(id = "last-name")
    public WebElement lastNameField;
    @FindBy(id = "postal-code")
    public WebElement postalCodeField;
    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;
    public String checkoutPageURL = "https://www.saucedemo.com/checkout-step-one.html";

    //--------------------------------------------------------------------


    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void inputPostalCode(String postalCode){
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

}
