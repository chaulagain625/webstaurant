package WebPages;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TableResultPage extends CommonMethods {
    @FindBy(xpath = "//div[@id='product_listing']/div/div[2]/a")
    public List<WebElement> allLinkForTable;
    @FindBy(xpath = "//*[@id=\"paging\"]/nav/ul/li[10]/a")
    public WebElement nextPage;
    @FindBy(xpath = "//*[@id=\"product_listing\"]/div[60]/div[4]/form/div/div/input[2]")
    public WebElement addToCart;
    @FindBy(xpath = "//select[@name='accessories']")
    public WebElement productAccessoriesSelection;
    @FindBy(xpath = "//*[@id=\"td\"]/div[11]/div/div/footer/button[2]")
    public WebElement addToCartButton;



    public TableResultPage() {
        PageFactory.initElements(driver, this);
    }
}
