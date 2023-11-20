package testsuite;
/**
 * Write down the following test into ‘RegisterTest’  class
 * 1. userShouldNavigateToRegisterPageSuccessful ly
 *      click on the ‘Register’ link
 *      Verify the text ‘Register’
 * 2. userSholdRegisterAccountSuccessfully *  click on the ‘Register’ link
 *      Select gender radio button
 *      Enter First name
 *      Enter Last name
 *      Select Day Month and Year
 *      Enter Email address
 *      Enter Password
 *      Enter Confirm password
 *      Click on REGISTER button
 *      Verify the text 'Your registration completed’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/"; // base URL

    @Before
    public void setUp () {
        openBrowser(baseUrl); // calling method from BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//a[@class= 'ico-register']")).click();  // find element for the registration page and click
        String expectedText = "Register"; // expected text
        String actualText = driver.findElement(By.xpath("//h1[text()='Register']")).getText();  // find actual test element and get the text from element
        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        Random random = new Random(); // create a object of Random class to get the unique email-id
        String randomEmail = "abcd" + random.nextInt() + "@gmail.com"; // use of random class object to get te unique number in the email-id

        userShouldNavigateToRegisterPageSuccessfully(); // re-direct to the registration page

        driver.findElement(By.xpath("//label[@for= 'gender-male']")).click(); // find element for Password field and enter valid password
        driver.findElement(By.id("FirstName")).sendKeys("Abcd"); // find element for Firstname field and enter valid firstname
        driver.findElement(By.id("LastName")).sendKeys("Xyz"); // find element for Lastname field and enter valid lastname
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")).sendKeys("1"); // find element for Date field and enter valid date
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']")).sendKeys("January"); // find element for Month field and enter valid month
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']")).sendKeys("1989"); // find element for Year field and enter valid year
        driver.findElement(By.id("Email")).sendKeys(randomEmail); // find element for Email field and enter valid email
        driver.findElement(By.id("Password")).sendKeys("abcd123"); // find element for Password field and enter valid password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abcd123"); // find element for ConfirmPassword field and enter valid confirm password
        driver.findElement(By.xpath("//button[@name = 'register-button']")).click(); // find element for login button and click

        String actualMessage = driver.findElement(By.xpath("//div[@class = 'result']")).getText(); // get the actual message after registration
        String expectedMessage = "Your registration completed"; // expected message

        Assert.assertEquals(expectedMessage, actualMessage); // verify expected and actual text
    }
    @After
    public void tearTown () {
        closeBrowser(); // calling method from BaseTest class to close the browser
    }
}
