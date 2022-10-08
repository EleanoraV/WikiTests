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
        driver.get("https://www.wikipedia.org/"); // goes to the page
        driver.manage().window().maximize(); //maximize window

    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // close window after tests
    }


    @Test
    public void getWeb() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        Select jazyk = new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']"))); // element of dropdown menu
        jazyk.selectByVisibleText("English"); // Select English language
        WebElement search = driver.findElement(By.xpath("//input[@id='searchInput']")); // element of input
        search.sendKeys("Ukraine"); // add text to input
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']")); //element of submit
        submit.click(); // submit


        String title = driver.getTitle(); // get title of the page


        Assert.assertEquals("Ukraine - Wikipedia", title); // make sure the title of the page is right


        List<WebElement> table = driver.findElements(By.xpath("//table[@class='infobox ib-country vcard']//tr")); // create a list all of elements of table
        System.out.println(table.size());
        Assert.assertEquals( 54, table.size()); // make sure there's 54 elements in the table


        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Economy']"))); //explicit wait

        System.out.println(text.getText());
        Assert.assertEquals("Economy", text.getText()); // make sure Economy is the text in element
  }









}


