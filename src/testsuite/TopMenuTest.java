package testsuite;
/**
 * Write down the following test into ‘TopMenuTest’  class
 * 1. userShouldNavigateToComputerPageSuccessfully
 *      click on the ‘Computers’ Tab
 *      Verify the text ‘Computers’
 * 2. userShouldNavigateToElectronicsPageSuccessfully
 *      click on the ‘Electronics’ Tab
 *      Verify the text ‘Electronics’
 * 3. userShouldNavigateToApparelPageSuccessfully
 *      click on the ‘Apparel’ Tab
 *      Verify the text ‘Apparel’
 * 4. userShouldNavigateToDigitalDownloadsPageSuccessfully
 *      click on the ‘Digital downloads’ Tab
 *      Verify the text ‘Digital downloads’
 * 5. userShouldNavigateToBooksPageSuccessfully
 *      click on the ‘Books’ Tab
 *      Verify the text ‘Books’
 * 6. userShouldNavigateToJewelryPageSuccessfully
 *      click on the ‘Jewelry’ Tab
 *      Verify the text ‘Jewelry’
 * 7. userShouldNavigateToGiftCardsPageSuccessfully
 *      click on the ‘Gift Cards’ Tab
 *      Verify the text ‘Gift Cards’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/"; // base URL

    @Before
    public void setUp () {
        openBrowser(baseUrl); // calling method from BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Computers ' ]")).click(); // find element and click
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Computers' ]")).getText(); // actual text on the redirected page
        String expectedText = "Computers"; // expected text
        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Electronics ' ]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Electronics' ]")).getText();
        String expectedText = "Electronics";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Apparel ' ]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Apparel' ]")).getText();
        String expectedText = "Apparel";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitaldownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Digital downloads ' ]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Digital downloads' ]")).getText();
        String expectedText = "Digital downloads";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Books ' ]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Books' ]")).getText();
        String expectedText = "Books";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Jewelry ' ]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Jewelry' ]")).getText();
        String expectedText = "Jewelry";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text() = 'Gift Cards ' ]")).click();
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Gift Cards' ]")).getText();
        String expectedText = "Gift Cards";
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearTown () {
        closeBrowser(); // calling method from BaseTest class to close the browser
    }
}
