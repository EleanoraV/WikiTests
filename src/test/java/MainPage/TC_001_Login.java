package MainPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TC_001_Login {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void init() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

    }

    @AfterClass
    public void teardown() {
        driver.quit();

    }


    @Test
    public void logintest() throws IOException {
        WebElement logine = driver.findElement(By.cssSelector("#pt-login"));
        logine.click(); // Go to login page

        driver.findElement(By.id("wpName1"))
                .sendKeys("AuTestingE"); // add login

        driver.findElement(By.cssSelector("#wpPassword1"))
                .sendKeys("youshallpass"); // add password
        driver.findElement(By.cssSelector("#wpRemember")).click(); //select Remember user
        driver.findElement(By.cssSelector("#wpLoginAttempt")).click(); //submit login and password
        String title = driver.getTitle(); // get title of the page

        Assert.assertEquals(title, "Wikipedia, the free encyclopedia"); // check that the title of webpage is right


        driver.findElement(By.xpath("//li[@id='pt-preferences']")).click(); // go to preferences
        WebElement feminine = driver.findElement(By.cssSelector("#ooui-php-24")); // find element - radiobutton
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", feminine); //click on radiobutton

        Assert.assertTrue(feminine.isSelected()); // make sure radiobutton was selected

        WebElement bodyelement = driver.findElement(By.xpath ("//a[@class='mw-wiki-logo']"));


        Screenshot screenshotw = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, bodyelement);

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new java.util.Date());
        String var = timeStamp + ".jpg";

        ImageIO.write(screenshotw.getImage(), "jpg", new File("R:\\Eliska\\Selenium\\Cucumber\\Wikipedia\\src\\test\\java\\MainPage\\Screenshots\\" + var)); // takes screenshot of the element

        BufferedImage expectedImage = ImageIO.read(new File("R:\\Eliska\\Selenium\\Cucumber\\Wikipedia\\src\\test\\java\\MainPage\\Screenshots\\fullimage.jpg")); //another image
        BufferedImage actualImage = screenshotw.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage); // finds our if the second picture looks the same

        Assert.assertTrue(diff.hasDiff()); // See if the images match h y







    }
}

