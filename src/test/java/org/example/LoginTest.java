package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private String baseURL;
    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("profile-directory=Profile 6");
        options.addArguments("--incognito");

//        options.addArguments("--user-data-dir=C:\\Users\\HP\\AppData\\Local" +
//                "\\Google\\Chrome\\User Data\\Default");

        driver = new ChromeDriver(options);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        baseURL = "https://www.powermyanalytics.com/";
        driver.get(baseURL);
    }

    @Test
    public void verify() {
        LandingPage landingPage = new LandingPage(driver);
        Trialpage trialpage = landingPage.clickStartFreeTrialLink();
        GoogleLoginPopUp googleLoginPopUp = trialpage.clickSignInWithGoogle();
        googleLoginPopUp.loginGoogleAccount();
    }
    @AfterClass
    public void tearDown() {
//        driver.quit();
    }


}
