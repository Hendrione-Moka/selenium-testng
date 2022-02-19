package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.QuoteHomePage;

public class AddQuoteTestWithPageObject {

  private ChromeDriver driver;

  @BeforeTest
  public void initializeSession() {
    //webdrivermanager
    WebDriverManager.chromedriver().setup();
    //chrome Options
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    //initialize browser
    driver = new ChromeDriver(options);
    //maximize
    driver.manage().window().maximize();
  }

  @AfterTest
  public void destroySession() throws InterruptedException {
    Thread.sleep(5000);
    //close browser
    driver.quit();
  }

  @Test
  public void addQuoteWithColorYellow() {
    QuoteHomePage homePage = new QuoteHomePage(driver);
    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("Yellow");
    homePage.clickButtonAddQuote();
    String actualData = homePage.getSecondQuote();
    Assert.assertEquals(actualData, "There is a will there is a way");
  }

  @Test
  public void addQuoteWithColorWhite() {
    QuoteHomePage homePage = new QuoteHomePage(driver);
    homePage.openPage();
    homePage.inputQuote("There is a will there is a way");
    homePage.selectColor("White");
    homePage.clickButtonAddQuote();
    String actualData = homePage.getSecondQuote();
    Assert.assertEquals(actualData, "There is a will there is a way");
  }

}
