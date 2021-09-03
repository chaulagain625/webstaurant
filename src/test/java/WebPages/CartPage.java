package WebPages;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonMethods {
    @FindBy(xpath="//*[@id='main']/div[3]/form/div/div[1]/div/a")
    public WebElement emptyCart;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement confirmEmptyCartButton;
    @FindBy(xpath="//div[@class='empty-cart__text']//p[1]")
    public WebElement emptyHeader;
    public CartPage(){
        PageFactory.initElements(driver,this);
    }

}
