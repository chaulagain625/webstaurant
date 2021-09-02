package WebPages;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  extends CommonMethods {

    @FindBy(xpath = "//input[@id='searchval']")
    public WebElement searchBar;

    @FindBy(xpath="//button[@value='Search']")
    public WebElement searchButton;
    @FindBy(xpath = "//span[@class='hidden xsl:inline']")
    public WebElement cart;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }



}
