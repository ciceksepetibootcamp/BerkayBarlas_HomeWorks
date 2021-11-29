package CicekSepetiWebUı;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;



public class Test2 {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeClass
    public static void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/berkaybarlas/Desktop/CicekSepetiWeb/chromedriver");
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.ciceksepeti.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.switchTo().defaultContent();
        driver.findElement(By.className("js-subheader-close")).click();
        driver.findElement(By.className("js-policy-close")).click();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }


    private void mouseHoverEffect(){
        WebElement mhe = driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]/div[2]/div[2]/nav[1]/ul[1]/li[2]/a[1]/span[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(mhe).perform();
    }

    @Test
    public void signUp() throws  InterruptedException{
        mouseHoverEffect();
        driver.findElement(By.xpath("//div/ul/li[2]/a/span")).click();
        driver.findElement(By.id("NameIndivual")).sendKeys("Berkay Barlas");
        driver.findElement(By.id("EmailIndivual")).sendKeys("qdmdasyyfdhdhpgddlqegxbtn@adfskj.com");
        driver.findElement(By.id("PasswordIndivual")).sendKeys("Test123");
        driver.findElement(By.partialLinkText("ticari elektronik ileti")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Okudum, Kabul Ediyorum')]")).click();
        driver.findElement(By.partialLinkText("Üyelik Sözleşme")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Okudum, Kabul Ediyorum')]")).click();
        driver.findElement(By.className("js-individual-register-button")).click();
        assertThat(driver.findElement(By.cssSelector(".membership-thanks__heading")).getText(), is("Teşekkürler!"));


    }


    @Test
    public void successfulLogin() {
        driver.findElement(By.cssSelector(".user-menu__item:nth-child(2)")).click();
        driver.findElement(By.className("users-process-list__btn")).click();
        driver.findElement(By.id("EmailLogin")).sendKeys("wjacvkpunbjtxiavsm@mrvpm.net");
        driver.findElement(By.id("Password")).sendKeys("Test");
        driver.findElement(By.className("login__btn")).click();
        assertThat(driver.findElement(By.className("user-menu__link--favorite")).getText(), is("Favorilerim"));


    }



    @After
    public void tearDown() {
        driver.quit();
    }



}
