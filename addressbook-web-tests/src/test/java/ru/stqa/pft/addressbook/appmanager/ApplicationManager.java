package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final ContactHelper contactHelper = new ContactHelper();

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\badzhelidze\\Desktop\\dev\\java_pft\\chromedriver.exe");
        contactHelper.groupHelper.wd = new ChromeDriver();
        contactHelper.groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        contactHelper.groupHelper.wd.get("http://localhost/addressbook/");
        contactHelper.groupHelper.wd.findElement(By.name("user")).click();
        contactHelper.groupHelper.wd.findElement(By.name("user")).clear();
        contactHelper.groupHelper.wd.findElement(By.name("user")).sendKeys(username);
        contactHelper.groupHelper.wd.findElement(By.name("pass")).click();
        contactHelper.groupHelper.wd.findElement(By.name("pass")).clear();
        contactHelper.groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
        contactHelper.groupHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        contactHelper.groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        contactHelper.groupHelper.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return contactHelper.groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
