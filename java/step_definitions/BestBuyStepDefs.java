package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BestBuyHomePage;
import pages.BestbuySearchResultPage;

import java.time.Duration;

public class BestBuyStepDefs {
    WebDriver driver;
    BestBuyHomePage bestBuyHomePage;
    BestbuySearchResultPage bestbuySearchResultPage;

    @Given("User navigate to bestbuy.com")
    public void user_navigate_to_bestbuy_com() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        bestBuyHomePage = new BestBuyHomePage(driver);

    }

    @When("User search Macbook Air 13")
    public void user_search_macbook_air() {
        bestBuyHomePage = new BestBuyHomePage(driver);
        bestBuyHomePage.handleAlert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        bestBuyHomePage.search("MacBook Air 13");


    }

    @Then("User should get {int} macbooks")
    public void user_should_get_macbooks(Integer count) {
        bestbuySearchResultPage = new BestbuySearchResultPage(driver);
        Assert.assertTrue(bestbuySearchResultPage.getResult() > count);
    }
}
