package testautomation.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumUtils {

    AndroidDriver driver;

    public AppiumUtils(AndroidDriver driver) {
        this.driver = driver;
    }


    public void pressSubmitButton() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

}
