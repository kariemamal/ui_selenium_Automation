package org.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends PageBase {
    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }


    public By pageTitle = By.cssSelector(".orangehrm-main-title");
    By firstNameField = By.cssSelector("input.orangehrm-firstname");
    By middleNameField = By.cssSelector("input.orangehrm-middlename");
    By lastNameField = By.cssSelector("input.orangehrm-lastname");
    By detailsToggle = By.cssSelector(".orangehrm-employee-form span.oxd-switch-input");
    By userNameField = By.cssSelector(".orangehrm-employee-form > div:nth-child(4) .oxd-grid-item--gutters:first-child input");
    By enableStatusRadio = By.cssSelector("[type='radio'][value='1'] span");
    By disableStatusRadio = By.cssSelector("[type='radio'][value='2']");
    By passwordField = By.cssSelector(".user-password-cell [type='password']");
    By confirmPasswordField = By.cssSelector(".user-password-row > div > div:last-child [type='password']");
    By cancelBtn = By.cssSelector(".oxd-form-actions button[type='button']");
    By saveBtn = By.cssSelector("button[type='submit']");

    public void createEmployee(String firstName, String middleName, String lastName) {
        type(firstNameField, firstName);
        type(middleNameField, middleName);
        type(lastNameField, lastName);
        click(saveBtn);
    }

    public void createEmployee(String firstName, String middleName, String lastName, String username, String password, boolean isEnabled) throws InterruptedException {
        type(firstNameField, firstName);
        type(middleNameField, middleName);
        type(lastNameField, lastName);
        click(detailsToggle);
        type(userNameField, username);
//        click(isEnabled ? enableStatusRadio : disableStatusRadio);
        type(passwordField, password);
        type(confirmPasswordField, password);
        click(saveBtn);
    }


}
