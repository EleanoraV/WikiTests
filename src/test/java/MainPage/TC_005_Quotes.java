package MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
// This test case is supposed to be run in parallel from testNG
public class TC_005_Quotes {


    @Test
    public void testOne() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikiquote.org/");
        driver.findElement(By.xpath("//a[@id='js-link-box-en']")).click(); // Select English element
        driver.findElement(By.xpath("//input[@class='vector-search-box-input']")).sendKeys("Emily Dickinson"); // Search for topic
        driver.findElement(By.xpath("//input[@id='searchButton']")).click(); // Submit search
        String edurl = driver.getCurrentUrl(); // URL of the website

        Assert.assertEquals(edurl, "https://en.wikiquote.org/wiki/Emily_Dickinson"); // make sure website is as described

        driver.quit();

    }
    @Test
    public void testTwo() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikiquote.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement selement = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//a[@id='js-link-box-en']"))); // explicit wait for element to be clickable
        selement.click();

        driver.findElement(By.xpath("//input[@class='vector-search-box-input']")).sendKeys("Virginia Woolf");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        String vwtitle = driver.getTitle();// Title of the website

        Assert.assertEquals(vwtitle, "Virginia Woolf - Wikiquote");

        driver.quit();

    }
    @Test
    public void testThree() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikiquote.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement selement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='js-link-box-en']")));
        selement.click();

        driver.findElement(By.xpath("//input[@class='vector-search-box-input']")).sendKeys("Kendrick Lamar");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        String kltitle = driver.getTitle(); // Title of the website

        Assert.assertEquals(kltitle, "Kendrick Lamar - Wikiquote");

        driver.quit();

    }




}
