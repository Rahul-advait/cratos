package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Trialpage {
    private WebDriver driver;
    private String SIGN_WITH_GOOGLE_LINK = ".sign-in-google-sm";

    public Trialpage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleLoginPopUp clickSignInWithGoogle() {
        WebElement signWithGoogleLink = driver.findElement(By.cssSelector(SIGN_WITH_GOOGLE_LINK));
        signWithGoogleLink.click();
        return new GoogleLoginPopUp(driver);
    }
}
