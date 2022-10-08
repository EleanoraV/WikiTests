package MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TC_003_CucumberWiki {

    //this must be run from test/resources/features/TC_003_CucumberWiki.feature
    WebDriver driver = new ChromeDriver();




    @Given("I am on the Wikipedia website")
    public void i_am_on_the_wikipedia_website() {
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();


    }
    @When("I click on the link of Google application and Apple application")
    public void i_click_on_the_link_of_google_application() {
        String WikiWindow = driver.getWindowHandle(); //get code of the window
        WebElement linkGoogle = driver.findElement(By.xpath("//span[@class='jsl10n sprite svg-badge_google_play_store']")); // element of link 1
        linkGoogle.click(); // click on link 2

        driver.switchTo().window(WikiWindow); // switch to the original window
        WebElement linkApple = driver.findElement(By.xpath("//span[@class='jsl10n sprite svg-badge_ios_app_store']")); // element of link 2
        linkApple.click(); // click on link 2


    }
    @Then("I am on following URLs")
    public void i_am_on_following_ur_ls() {
        ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles()); // make a list of window handles

        driver.switchTo().window(tabsList.get(2)); // go to third window in list
        String url2 = driver.getCurrentUrl();
        System.out.println("URL2: " + url2);
        Assert.assertEquals( "https://apps.apple.com/app/apple-store/id324715238", url2); // make sure url is as described

        driver.switchTo().window(tabsList.get(1));  // go to second window in list
        String url1 = driver.getCurrentUrl();
        System.out.println("URL1: " + url1);
        Assert.assertEquals("https://play.google.com/store/apps/details?id=org.wikipedia&referrer=utm_source%3Dportal%26utm_medium%3Dbutton%26anid%3Dadmob", url1); // make sure url is as described



        driver.switchTo().window(tabsList.get(0));// go to first window in list
        String url0 = driver.getCurrentUrl();
        System.out.println("URL0: " + url0);
        Assert.assertEquals(url0, "https://www.wikipedia.org/"); // make sure url is as described



        driver.quit(); // close browser

    }



}
