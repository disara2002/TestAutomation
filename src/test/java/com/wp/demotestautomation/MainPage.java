package com.wp.demotestautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.logging.XMLFormatter;

// page_url = https://demoqa.com/
public class MainPage {
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement optionElements;

    @FindBy(xpath = "//span[@class='text']")
    public WebElement elementsTextBox;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userFullName;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmail;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement userCurrentAddress;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    public WebElement userPermanentAddress;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='Check Box']")
    public WebElement elementsCheckBox;

    @FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
    public WebElement checkBoxExpandArrow;

    @FindBy(xpath = "(//span[@class='rct-checkbox'])[2]")
    public WebElement checkBoxDesktop;

    @FindBy(xpath = "//span[text()='Radio Button']")
    public WebElement elementsRadioButton;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    public WebElement radioButtonYes;

    @FindBy(xpath = "//span[text()='Buttons']")
    public WebElement elementsButtons;

    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    public WebElement buttonsDoubleClickButton;

    @FindBy(xpath = "//h5[text()='Widgets']")
    public WebElement optionWidgets;

    @FindBy(xpath = "//span[text()='Date Picker']")
    public WebElement widgetsDatePicker;

    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    public WebElement selectDate;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement optionAlerts;

    @FindBy(xpath = "//span[text()='Modal Dialogs']")
    public WebElement alertsModalDialogs;

    @FindBy(xpath="//button[@id='showSmallModal']")
    public WebElement modalDialogSmallButton;

    @FindBy(xpath="//button[@id='closeSmallModal']")
    public WebElement modalCloseDialogSmallButton;

    @FindBy(xpath = "//span[text()='Links']")
    public  WebElement elementsLinks;

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement linksHome;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
