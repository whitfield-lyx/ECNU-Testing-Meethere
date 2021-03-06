// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class AddOrderTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver","./geckodriver");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void addOrder() {
    driver.manage().window().setSize(new Dimension(1440, 900));
    driver.get("http://localhost:8081/");
    driver.findElement(By.cssSelector(".input_style:nth-child(1) > .el-input__inner")).click();
    driver.findElement(By.cssSelector(".input_style:nth-child(1) > .el-input__inner")).sendKeys("user01");
    driver.findElement(By.cssSelector(".input_style:nth-child(2) > .el-input__inner")).click();
    driver.findElement(By.cssSelector(".input_style:nth-child(2) > .el-input__inner")).sendKeys("123456");
    driver.findElement(By.cssSelector(".el-button--primary")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".el-message el-message--success"));
      assert(elements.size() == 0);
    }
    driver.findElement(By.cssSelector(".el-table__fixed-body-wrapper .el-table__row:nth-child(3) span")).click();//第三个场馆
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".el-message el-message--success"));
      assert(elements.size() == 0);
    }
    driver.findElement(By.cssSelector(".el-date-editor--date > .el-input__inner")).click();
    driver.findElement(By.cssSelector(".available:nth-child(6) > div")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".el-button--primary"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".el-date-editor--time-select > .el-input__inner")).click();
    driver.findElement(By.cssSelector(".time-select-item:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".el-button--primary > span")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".el-button--primary > span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".el-button--small:nth-child(2) > span")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".el-message el-message--success"));
      assert(elements.size() == 0);
    }
  }
}
