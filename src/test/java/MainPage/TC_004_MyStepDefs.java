package MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TC_004_MyStepDefs {
    //This must be run from test/resources/features/TC_004_MyStepDefs.feature
    WebDriver driver = new ChromeDriver();



    @Given("I open wikipedia page")
    public void i_open_wikipedia_page() {

        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();

    }

    @When("I search for {word}")
    public void iSearchForCountry(String country) throws InterruptedException {
        //Select language:
        Select jazyk = new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']")));
        jazyk.selectByVisibleText("English");

        // Send input and click submit:
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchInput.sendKeys(country);
        driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']")).click();
        //Implicit wait:
        Thread.sleep(4000);


    }


    @Then("I'm on page of {word}")
    public void i_m_on_page_of(String country) {
        //Make sure the title is as it should be
        String webtitle = driver.getTitle();
        Assert.assertEquals(country + " - Wikipedia", webtitle);

    }


    @After
    public void teardown() {
        driver.quit();
    }

}





