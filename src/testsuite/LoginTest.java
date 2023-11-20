package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 *      click on the ‘Login’ link Verify the text ‘Welcome, Please Sign In!’
 * 2. userShouldLoginSuccessfullyWithValidCredentials * click on the ‘Login’ link
 *      Enter valid username
 *      Enter valid password
 *      Click on ‘LOGIN’ button
 *      Verify the ‘Log out’ text is display
 * 3. verifyTheErrorMessage
 *      click on the ‘Login’ link
 *      Enter invalid username
 *      Enter invalid password
 *      Click on Login button
 *      Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/"; // base URL

    @Before
    public void setUp () {
        openBrowser(baseUrl); // calling method from BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Log in")).click(); // find element for the login page and click
        String expectedText = "Welcome, Please Sign In!"; // expected text
        String actualText = driver.findElement(By.xpath("//h1")).getText();  // find actual test element and get the text from element
        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        userShouldNavigateToLoginPageSuccessfully(); // re-direct to the login page

        driver.findElement(By.name("Email")).sendKeys("abcd@gmail.com"); // find element for Email field and enter valid login-id
        driver.findElement(By.name("Password")).sendKeys("abcd123"); // find element for Password field and enter valid password
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click(); // find element for login button and click
        String actualValue = driver.findElement(By.xpath("//a[text() = 'Log out']")).getText(); // get the text from page to verify the re-direction
        String expectedValue = "Log out"; // expected text
        Assert.assertEquals(expectedValue, actualValue); // verify expected and actual text
    }

    @Test
    public void verifyTheErrorMessage(){
        userShouldNavigateToLoginPageSuccessfully(); // // re-direct to the login page

        driver.findElement(By.id("Email")).sendKeys("abc123@gmail.com"); // find element for Email field and enter valid login-id
        driver.findElement(By.name("Password")).sendKeys("1234"); // find element for Password field and enter in-valid password
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click(); // find element for login button and click

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"; // expected error message

        //finding actual error message
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText();

        Assert.assertEquals("Error Message not matched",expectedErrorMessage, actualErrorMessage); // verify expected and actual text
    }

    @After
    public void tearTown () {
        closeBrowser(); // calling method from BaseTest class to close the browser
    }

}
