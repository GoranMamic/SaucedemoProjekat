package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageStep2 extends BaseTest {
    public CheckoutPageStep2() {{PageFactory.initElements(driver, this);}}

    @FindBy(id = "finish")
    public WebElement finishButton;
    @FindBy(className = "title")
    public WebElement ChekoutOverview;
    @FindBy(css = ".summary_info_label.summary_total_label")
    public WebElement totalPrice;
    public String checkoutPageStep2URL ="https://www.saucedemo.com/checkout-step-two.html";
}
