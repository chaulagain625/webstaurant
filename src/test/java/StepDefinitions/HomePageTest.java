package StepDefinitions;

import Utilities.CommonMethods;
import WebPages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest extends CommonMethods {
    @Given("The user navigate to url and landed on webstaurant store home page")
    public void the_user_navigate_to_url_and_landed_on_webstaurant_store_home_page() {

    }



    @When("User enter {string} and click on search button")
    public void user_enter_and_click_on_search_button(String text) {
       HomePage homePage= new HomePage();
        sendText(homePage.searchBar,text);
        click(homePage.searchButton);
    }


}
