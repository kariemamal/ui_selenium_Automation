package org.hrm;

import org.openqa.selenium.By;

public class DashboardPage extends PageBase {
    public DashboardPage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }



    public By dashboardItem = By.xpath("//span[text()='Dashboard']");
    By employeeMenu = By.xpath("//span[text()='PIM']");


    public void openEmployeePage() {
        click(employeeMenu);
    }
}
