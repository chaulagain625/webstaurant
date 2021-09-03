package WebPages;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TableResultPage extends CommonMethods {
    @FindBy(xpath = "//div[@id='product_listing']/div/div[2]/a")
    public List<WebElement> allLinkForTable;
    @FindBy(xpath = "(//input[@class='btn btn-cart btn-small'])[51]")
    public WebElement addToCart;

    public TableResultPage() {
        PageFactory.initElements(driver, this);
    }
}
