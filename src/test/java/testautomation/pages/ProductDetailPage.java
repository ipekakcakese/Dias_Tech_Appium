package testautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    @FindBy(xpath = "//android.widget.TextView[@text=\"En ucuz mağazaya git\"]")
    WebElement goToSellerButton;

    AndroidDriver driver;
    WebDriverWait wait;

    public ProductDetailPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isGoToSellerButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(goToSellerButton)).isDisplayed();
    }
}