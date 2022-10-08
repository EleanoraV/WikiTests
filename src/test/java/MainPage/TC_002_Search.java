package MainPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_002_Search {
        WebDriver driver = new ChromeDriver();




    @BeforeClass
    public void init() {
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void getWeb() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        Select jazyk = new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']")));
        jazyk.selectByVisibleText("English");
        WebElement search = driver.findElement(By.xpath("//input[@id='searchInput']"));
        search.sendKeys("Ukraine");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();


        String title = driver.getTitle();


        Assert.assertEquals(title, "Ukraine - Wikipedia");


        List<WebElement> table = driver.findElements(By.xpath("//table[@class='infobox ib-country vcard']//tr"));
        System.out.println(table.size());
        Assert.assertEquals( 54, table.size());


        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Economy']")));

        System.out.println(text.getText());
        Assert.assertEquals("Economy", text.getText());
  }









}


