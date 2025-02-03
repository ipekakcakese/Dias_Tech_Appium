package testautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.utils.AppiumUtils;

import java.time.Duration;

public class ProductListPage {
    @FindBy(xpath = "//android.widget.TextView[@text='Filtrele']")
    WebElement filterButton;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"Kategoriler\"])[1]")
    WebElement categories;

    @FindBy(xpath = "//android.widget.RadioButton[@text=\"Dizüstü Bilgisayar\"]")
    WebElement computer;

    @FindBy(xpath = "//android.widget.RadioButton[@text=\"Klavye - Mouse\"]")
    WebElement keyBoardAndMouse;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"btn-apply-filter\"]")
    WebElement applyFilterButton;

    @FindBy(xpath = "//android.view.View[@resource-id=\"sorting\"]")
    WebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"En Yüksek Fiyat\"]")
    WebElement highestPriceSort;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='productImage'])[10]")
    WebElement tenthProduct;

    AndroidDriver driver;
    WebDriverWait wait;
    AppiumUtils utils;

    public ProductListPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.utils = new AppiumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void applyFilters() {
        wait.until(ExpectedConditions.visibilityOf(filterButton)).click();
        wait.until(ExpectedConditions.visibilityOf(categories)).click();
      wait.until(ExpectedConditions.visibilityOf(computer)).click();
       wait.until(ExpectedConditions.visibilityOf(keyBoardAndMouse)).click();
      wait.until(ExpectedConditions.visibilityOf(applyFilterButton)).click();
    }

    public void sortByHighestPrice() {
        wait.until(ExpectedConditions.visibilityOf(sortButton)).click();
        wait.until(ExpectedConditions.visibilityOf(highestPriceSort)).click();
    }

    public void selectTenthProduct() {
        wait.until(ExpectedConditions.visibilityOf(tenthProduct)).click();
    }
}
