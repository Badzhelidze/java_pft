package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;


    public void init() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);

        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
        wd.get("http://localhost/addressbook/");
    }


    public void stop() {
        wd.quit();
    }

    public void addNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void gotoContactPage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void chooseContact() {
        wd.findElement(By.name("selected[]")).click();
    }



}
