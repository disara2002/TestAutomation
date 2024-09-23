package com.wp.demotestautomation;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

   @Test
   public void TestCase01() {
       // Scroll to the "Elements" section
       WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

       // Navigate to the Elements section
       mainPage.optionElements.click();

       //click on the Text Box
       mainPage.elementsTextBox.click();

       // Fill out the form
       mainPage.userFullName.sendKeys("Disara Kannangara");
       mainPage.userEmail.sendKeys("disarakk@gmail.com");
       mainPage.userCurrentAddress.sendKeys("No.123,Main rd,Colombo");
       mainPage.userPermanentAddress.sendKeys("No.456,Temple rd,Colombo");

       // Scroll to the "Submit" section
       WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
       // Submit the form
       mainPage.submitButton.click();

       // Validate fields
       WebElement validateFullName = driver.findElement(By.xpath("//p[@id='name']"));
       assertEquals(validateFullName.getText(), "Name:Disara Kannangara");

       WebElement validateEmail = driver.findElement(By.xpath("//p[@id='email']"));
       assertEquals(validateEmail.getText(), "Email:disarakk@gmail.com");

       WebElement validateCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
       assertEquals(validateCurrentAddress.getText(), "Current Address :No.123,Main rd,Colombo");

       WebElement validatePermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
       assertEquals(validatePermanentAddress.getText(), "Permananet Address :No.456,Temple rd,Colombo");

   }

   @Test
    public void TestCase02(){
       // Scroll to the "Elements" section
       WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

       // Navigate to the Elements section
       mainPage.optionElements.click();

       //Navigate to check box
       mainPage.elementsCheckBox.click();

       //Navigate to the expand arrow
       mainPage.checkBoxExpandArrow.click();

       WebElement checkboxDesktop = driver.findElement(By.xpath("//span[@class='rct-title']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",checkboxDesktop);
       //click on desktop
       mainPage.checkBoxDesktop.click();

       WebElement scrollToResultCheckBox = driver.findElement(By.xpath("//div[@class='display-result mt-4']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollToResultCheckBox);

       WebElement selectionsValidation = driver.findElement(By.xpath("//div[@id='result']"));
       assertEquals("You have selected :\n" +
               "desktop\n" +
               "notes\n" +
               "commands",selectionsValidation.getText());

   }

    @Test
    public void TestCase03(){
        //Scroll to elements
        WebElement elementHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elementHeading);

        //Navigate to elements
        mainPage.optionElements.click();

        //Navigate to radio buttons
        mainPage.elementsRadioButton.click();

        //click on yes radio button
        mainPage.radioButtonYes.click();

        // Locate the parent <p> element that contains both the static text and the dynamic span
        WebElement radioButtonResult = driver.findElement(By.xpath("//p[@class='mt-3']"));
        assertEquals("You have selected Yes", radioButtonResult.getText());

    }

    @Test
    public void TestCase04() {
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        // Navigate to the Elements section
        mainPage.optionElements.click();

        //Navigate to the buttons page
        mainPage.elementsButtons.click();

        //Double click
        Actions action = new Actions(driver);

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        action.doubleClick(doubleClickButton).build().perform();

        WebElement doubleClickMessage = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doubleClickMessage);
        assertEquals("You have done a double click", doubleClickMessage.getText());
    }

    @Test
    public void TestCase05() {
        // Scroll to the "Widgets" section
        WebElement widgetsHeading = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsHeading);

        // Navigate to the Widgets section
        mainPage.optionWidgets.click();

        // Navigate to the date picker page
        mainPage.widgetsDatePicker.click();

        // Click on select date
        mainPage.selectDate.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-datepicker']")));

        // Use Select to handle the month dropdown
        Select monthDropdown = new Select(driver.findElement(By.className("react-datepicker__month-select")));

        // Select the month October
        monthDropdown.selectByValue("9");

        // Use Select to handle the year dropdown
        Select yearDropdown = new Select(driver.findElement(By.className("react-datepicker__year-select")));

        // Select the year 2024
        yearDropdown.selectByValue("2024");

        // Wait for both selections to be applied
        wait.until(ExpectedConditions.textToBePresentInElement(monthDropdown.getFirstSelectedOption(), "October"));
        wait.until(ExpectedConditions.textToBePresentInElement(yearDropdown.getFirstSelectedOption(), "2024"));

        // Select the 15th day of the month
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--015')]")).click();
    }

    @Test
    public void TestCase06(){
        // Scroll to the "Widgets" section
        WebElement alertsHeading = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertsHeading);

        //Navigate to alerts
        mainPage.optionAlerts.click();

        //Scroll to modal dialogs
        WebElement scrollToModalDialogs = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToModalDialogs);

        //Navigate to modal dialogs
        mainPage.alertsModalDialogs.click();

        //Click on the small button
        mainPage.modalDialogSmallButton.click();

        //Close the small button popup
        mainPage.modalCloseDialogSmallButton.click();
    }

    @Test
    public void TestCase07(){
        // Scroll to the "Elements" section
        WebElement elementsHeading = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsHeading);

        // Navigate to the Elements section
        mainPage.optionElements.click();

        //Navigate to Links
        mainPage.elementsLinks.click();

        //Click on Home
        mainPage.linksHome.click();
    }

}



