package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    /* it will switch window given target title */
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> ids=driver.getWindowHandles();
        for(String id:ids){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    //home Work implement the method that swich the window by url
    /*
    It will close all the windows if it is not equals to given window title */

    public static void closeWindowsByTitle(WebDriver driver, String title){
        Set<String> ids=driver.getWindowHandles();
        for(String id: ids){
            driver.switchTo().window(id);
            if(!driver.getTitle().equals(title)){
                driver.close();
            }
        }
    }

    public static void scrollToView(WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }


    //we will create our reusable methods related with browser
    //inside the BrowserUtils class

    /*
    Method that accepts three param - WebElement and Value and MethodName
    SelectByVisibleText
     */
    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);
        //method name can be text, index, value
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "va lue":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Use text, value, or index for method name");
        }
    }

    // method will get the text from the webelement and trim it.
    public static String getText(WebElement element){
        return element.getText().trim();
    }
   //File comes from Java;


    //purpose of screenshot method to show where your test is failing , and we need to provide in @AfterMethod ;
    public static  void getScreenShot(WebDriver driver, String packageName){
        //getScreenShotAs method is taking a screenshot and returning the file of this screen.
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //TakesScreenShot class comes from Selenium , u need to cast to driver
        //getScreenshotAs comes from that class
        //return type is File;

        String location=System.getProperty("user.dir")+"/src/main/screenshot/"+packageName+"/";
        //System.getProperty("user.dir") ready method which gives us location of project and comes from System(java)
        //We create the one folder to store screenshots location;
        //String packageName-> u will provide the package name inside of after method
        try {
            FileUtils.copyFile(file, new File(location+System.currentTimeMillis()+".png"));
            //System.currentTimeMillis() -> to get unique name for screenshot (will be some numbers)
        } catch (IOException e) {
            System.out.println("screenshot is not stored.");
            e.printStackTrace();
        }
    }


}
