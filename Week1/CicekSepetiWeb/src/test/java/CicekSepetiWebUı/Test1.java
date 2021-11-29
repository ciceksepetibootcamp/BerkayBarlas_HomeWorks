package CicekSepetiWebUı;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;
import org.junit.*;


public class Test1 {

    private void search() {
        driver.findElement(By.xpath(searchButton)).click();
    }

    private void textSearchDec(String value) {
        driver.findElement(By.xpath(textInput)).sendKeys(value);
    }

    private void clearSearch() {
        driver.findElement(By.xpath(textInput)).clear();
    }

    private void searchInputClick() {
        driver.findElement(By.xpath(textInput)).click();
    }

    private void clearHistoryButton() {
        driver.findElement(By.xpath(clearHistoryButton)).click();
    }

    private final static String clearHistoryButton = "//strong[contains(text(),'Temizle')]";
    private final static String textInput = "//body/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]";
    private final static String searchButton = "//body/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]";
    private static final String URL = "https://www.ciceksepeti.com/cikolata?prc=0-50";
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


    @Test
    public void productFilter() {
        driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.linkText("Fiyat")).click();
        driver.findElement(By.id("max-price-filter")).click();
        driver.findElement(By.id("max-price-filter")).sendKeys("50");
        driver.findElement(By.cssSelector(".filter__price-range-apply-button > .icon-right-arrow")).click();
        Assert.assertEquals(URL, "https://www.ciceksepeti.com/cikolata?prc=0-50");
        System.out.println("Same URL");
    }

    @Test
    public void clearHistory() throws InterruptedException {
        textSearchDec("Ayakkabı");
        search();
        clearSearch();
        textSearchDec("Gömlek");
        search();
        clearSearch();
        textSearchDec("Pantolon");
        search();
        clearSearch();
        searchInputClick();
        clearHistoryButton();
        System.out.println("Clear history successfuly");
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}
