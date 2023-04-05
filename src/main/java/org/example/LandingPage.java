package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;
    private String START_FREE_TRIAL_LINK = ".mediumB";

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public Trialpage clickStartFreeTrialLink(){
        WebElement startFreeLink = driver.findElement(By.cssSelector(START_FREE_TRIAL_LINK));
        startFreeLink.click();
        return new Trialpage(driver);
    }

}
