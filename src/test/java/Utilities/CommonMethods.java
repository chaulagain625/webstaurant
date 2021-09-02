package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class CommonMethods {
    public static WebDriver driver;
    static String path;

    /**
     * This method help to lunch the browser (either chrome or firefox with help of switch case)
     * and navigate to the url. After that it will maximize the window and apply
     * implicit wait.
     */
    public static void setUp() {
        path = Constants.CONFIGURATION_FILEPATH;
        propertiesReader.readProperties(path);
        switch (propertiesReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Please choose either chrome or firefox");
        }
        driver.get(propertiesReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /**
     * This method will close the browser if the browser not equal to null.
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * This method will take two parameter web element and string
     * @param element web element as a locators.
     * @param string String as a text.
     * It locates the element and send the text.
     */
    public static void sendText(WebElement element, String string) {
        element.sendKeys(string);
    }

    /**
     * This method takes one parameter of Web Element and click the element
     * @param element web element.
     */
    public static void click(WebElement element){
        element.click();
    }

    /**
     * This method help to takes the screenshot and stores in the given file path.
     * @param fileName
     * @return
     *
     */
      public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    /**
     * This method is to generate the current time for the screenshot method.
     * It takes the String of pattern and return the current date and time on the same pattern.
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


}
