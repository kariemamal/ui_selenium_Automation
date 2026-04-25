package org.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameField = By.cssSelector("input.oxd-input[name='username']");
    By passwordField = By.cssSelector("input.oxd-input[name='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(submitBtn);
    }

}
