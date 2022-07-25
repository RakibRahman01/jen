import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class window {

   @Test
           public void window(){
        System.setProperty("webdriver.gecko.driver","/Users/rakib/Dev_Tools/geckodriver");
        WebDriver driver= new FirefoxDriver();
        driver.get("https://www.github.com");
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.COMMAND).moveToElement(driver.findElement(By.xpath("//a[text()='Marketplace']"))).click().perform();
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Set<String> allWindows= driver.getWindowHandles();
        int size= allWindows.size();
        System.out.println(size);
        for(String child:allWindows){
            if (!parent.equalsIgnoreCase(child)){
                driver.switchTo().window(child);

            }
        }

    }
    @Test
    public void multipleWindows() {
        System.setProperty("webdriver.gecko.driver", "/Users/rakib/Dev_Tools/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.delta.com/");
            driver.findElement(By.xpath("//a[@class='sign-up btn btn-link']")).click();
            WebElement community= driver.findElement(By.xpath("//a[contains (text(),'Privacy Policy.')]"));
        community.click();
        String parent_window= driver.getWindowHandle();
        System.out.println(parent_window);
        Set<String> allWindow= driver.getWindowHandles();
        System.out.println(allWindow.size());
        for (String childwindow:allWindow
             ) {
            if (!childwindow.equalsIgnoreCase(parent_window)){
                driver.switchTo().window(parent_window);
                        System.out.println(driver.getTitle());
          }


        }
    }
    @Test
    public void dropdown(){
        System.setProperty("webdriver.gecko.driver", "/Users/rakib/Dev_Tools/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement element= driver.findElement(By.xpath("//select[@name='country']"));
        Select select= new Select(element);
      select.selectByVisibleText("ANTARCTICA");
      List<WebElement> ele= select.getOptions();
        System.out.println(ele.size());

    }
    @Test
    public void RightClick(){
        System.setProperty("webdriver.gecko.driver", "/Users/rakib/Dev_Tools/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.delta.com/");
        Actions actions= new Actions(driver);
        WebElement element= driver.findElement(By.id("adv-search"));
        actions.contextClick(element).build().perform();


    }
    @Test
    public void draganddrop(){
        System.setProperty("webdriver.gecko.driver", "/Users/rakib/Dev_Tools/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.delta.com/");
        Actions a= new Actions(driver);
        WebElement souce= driver.findElement(By.id("source"));
         WebElement target= driver.findElement(By.id("target"));
        a.dragAndDrop(souce,target).build().perform();
        TakesScreenshot screenshot= (TakesScreenshot)driver;
        File file= screenshot.getScreenshotAs(OutputType.FILE);

    }


}
