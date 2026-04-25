package org.hrm;

import org.openqa.selenium.By;

public class EmployeePage extends PageBase {
    public EmployeePage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    public By pageTitle = By.cssSelector("h6[class*='oxd-topbar-header-breadcrumb-module']");
    By EmployeesRows = By.cssSelector(".oxd-table-body .oxd-table-row");
//    By deleteBtn = EmployeesRows.cssSelector(".bi-trash");
    By addIcon = By.cssSelector("button .bi-plus");


    public void OpenAddEmployeePage() {
        click(addIcon);
    }

}
