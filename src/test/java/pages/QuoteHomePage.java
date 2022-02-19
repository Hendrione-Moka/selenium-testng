package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QuoteHomePage {

  private ChromeDriver driver;

  public QuoteHomePage(ChromeDriver driver) {
    this.driver = driver;
  }

  public void openPage(){
    driver.get("http://bdd.atlasid.tech/");
  }

  public void inputQuote(String quote){
    By locatorInputQuote = By.id("inputQuote");
    WebElement inputQuote = driver.findElement(locatorInputQuote);
    inputQuote.sendKeys(quote);
  }

  public void selectColor(String color){
    By locatorSelectColor = By.id("colorSelect");
    WebElement selectColor = driver.findElement(locatorSelectColor);
    Select select = new Select(selectColor);
    select.selectByVisibleText(color);
  }

  public void clickButtonAddQuote(){
    By locatorButtonAddQuote = By.id("buttonAddQuote");
    WebElement buttonAddQuote = driver.findElement(locatorButtonAddQuote);
    buttonAddQuote.click();
  }

  public String getSecondQuote(){
    //findElements
    By locatorLabelQuotes = By.name("quoteText");
    List<WebElement> quotes = driver.findElements(locatorLabelQuotes);
    //ambil quote kedua
    WebElement secondQuote = quotes.get(1);
    String actualData = secondQuote.getText();
    return actualData;
  }
}
