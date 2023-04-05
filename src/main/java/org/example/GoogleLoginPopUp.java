package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleLoginPopUp {
    private WebDriver driver;
    private String EMAIL = "#identifierId";
    private String NEXT = "#identifierNext .VfPpkd-RLmnJb";
    private String PASSWORD = "input[name='password']";
    private String password_NEXT = "#passwordNext .VfPpkd-vQzf8d";


    public GoogleLoginPopUp(WebDriver driver) {
        this.driver = driver;
    }

    public void loginGoogleAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String parentWindow = driver.getWindowHandle();
        System.out.println(driver.getWindowHandles().size());

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().contains("=profile")) {
                break;
            }
        }

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EMAIL)));
        emailField.sendKeys("rahul.quality.analyst@gmail.com");
        driver.findElement(By.cssSelector(NEXT)).click();
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(PASSWORD)));
        passwordField.sendKeys("1@mThestar19");
        driver.findElement(By.cssSelector(password_NEXT)).click();

        driver.switchTo().window(parentWindow);

        System.out.println(driver.getTitle());

    }
}
