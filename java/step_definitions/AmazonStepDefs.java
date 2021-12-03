package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;

import java.util.List;

public class AmazonStepDefs {
    WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultsPage;

    @When("I navigate to Amazon home page")
    public void i_navigate_to_amazon_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

    }

    @And("I search for iphone 13 case")
    public void i_search_for_iphone_case() {
        amazonHomePage=new AmazonHomePage(driver);
        amazonHomePage.search("iphone 13 case");
//        WebElement amazonSearchField = driver.findElement(By.id("twotabsearchtextbox"));
//        amazonSearchField.sendKeys("iphone 13 case");
//
//        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
//        searchButton.click();

    }

    @Then("I should get more than {int} result")
    public void i_should_get_more_than_result(Integer resultCount) {
        amazonSearchResultsPage=new AmazonSearchResultsPage(driver);

//        List<WebElement> resultLink = driver.findElements(By.tagName("a"));
        Assert.assertTrue(amazonSearchResultsPage.getResultCount()>resultCount);
    }

    @And("I validate the search result number")
    public void i_validate_the_search_result_number() {

        WebElement resultsText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small " +
                "a-spacing-top-small']"));
       String [] resultsArr = resultsText.getText().split(" ");
       String resultNum = resultsArr[3].replace(",","");
       int results = Integer.parseInt(resultNum);
       Assert.assertEquals(results, 20000);

    }

}
