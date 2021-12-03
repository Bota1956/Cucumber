package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestBuyHomePage {

    public BestBuyHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gh-search-input")
    private WebElement searchBox;

    @FindBy(className = "header-search-icon")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@class='c-close-icon c-modal-close-icon']")
    private  WebElement alert;


    public void search(String searchProduct){
        searchBox.sendKeys(searchProduct);
        searchButton.click();
    }

    public void handleAlert(){
        alert.click();

    }

}
