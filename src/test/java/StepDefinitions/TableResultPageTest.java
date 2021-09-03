package StepDefinitions;

import Utilities.CommonMethods;
import WebPages.CartPage;
import WebPages.HomePage;
import WebPages.TableResultPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class TableResultPageTest extends CommonMethods {
    @Then("User verify the {string} in the title")
    public void user_verify_the_in_the_title(String string) {
        TableResultPage tableResultPage= new TableResultPage();

        for(WebElement link: tableResultPage.allLinkForTable){
            if(link.getText().contains(string)) {
                boolean actual = link.getText().contains(string);
                Assert.assertTrue(actual);
            }
       }


    }
    @Then("The user add the last found in the cart and empty the cart")
    public void the_user_add_the_last_found_in_the_cart_and_empty_the_cart() throws InterruptedException {
        TableResultPage tableResultPage= new TableResultPage();
        HomePage homePage = new HomePage();
        CartPage cartPage = new CartPage();
        tableResultPage.addToCart.click();
        Thread.sleep(6000);
        click(homePage.cart);
        cartPage.emptyCart.click();
        cartPage.confirmEmptyCartButton.click();

    }
    @Then("verify the cart is empty")
    public void verify_the_cart_is_empty() throws InterruptedException {
        CartPage cartPage= new CartPage();
         Thread.sleep(3000);

        String expectedText ="Your cart is empty.";
        String actualText=cartPage.emptyHeader.getText();
        System.out.println("Actual text :"+actualText);
        Assert.assertEquals(expectedText,actualText);

    }
}
