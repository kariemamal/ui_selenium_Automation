package org.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends PageBase {
    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    By pageTitle = By.cssSelector("h6[class*='oxd-topbar-header-breadcrumb-module']");


}
