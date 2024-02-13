package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {
    public CartPage() {{PageFactory.initElements(driver, this);}}

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShopping;
    @FindBy(className = "cart_item")
    public WebElement cartItem;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpackFromCart;



    //------------------------------------------------------------------




}
