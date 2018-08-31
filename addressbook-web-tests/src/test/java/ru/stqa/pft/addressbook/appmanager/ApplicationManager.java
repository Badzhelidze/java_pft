package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private GroupHelper groupHelper;

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
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        groupHelper.wd.get("http://localhost/addressbook/");
        groupHelper.wd.findElement(By.name("user")).click();
        groupHelper.wd.findElement(By.name("user")).clear();
        groupHelper.wd.findElement(By.name("user")).sendKeys(username);
        groupHelper.wd.findElement(By.name("pass")).click();
        groupHelper.wd.findElement(By.name("pass")).clear();
        groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
        groupHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        groupHelper.wd.quit();
    }

    public void fillContactForm(ContactData contactData) {
        groupHelper.wd.findElement(By.name("firstname")).click();
        groupHelper.wd.findElement(By.name("firstname")).clear();
        groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getMyname());
        groupHelper.wd.findElement(By.name("middlename")).click();
        groupHelper.wd.findElement(By.name("middlename")).clear();
        groupHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMysurname());
        groupHelper.wd.findElement(By.name("lastname")).click();
        groupHelper.wd.findElement(By.name("lastname")).clear();
        groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getMylastname());
        groupHelper.wd.findElement(By.name("nickname")).click();
        groupHelper.wd.findElement(By.name("nickname")).clear();
        groupHelper.wd.findElement(By.name("nickname")).sendKeys(contactData.getMynick());
        groupHelper.wd.findElement(By.name("title")).click();
        groupHelper.wd.findElement(By.name("title")).clear();
        groupHelper.wd.findElement(By.name("title")).sendKeys(contactData.getMytitle());
        groupHelper.wd.findElement(By.name("company")).click();
        groupHelper.wd.findElement(By.name("company")).clear();
        groupHelper.wd.findElement(By.name("company")).sendKeys(contactData.getMycompany());
        groupHelper.wd.findElement(By.name("address")).click();
        groupHelper.wd.findElement(By.name("address")).clear();
        groupHelper.wd.findElement(By.name("address")).sendKeys(contactData.getMyaddress());
        groupHelper.wd.findElement(By.name("home")).click();
        groupHelper.wd.findElement(By.name("home")).clear();
        groupHelper.wd.findElement(By.name("home")).sendKeys(contactData.getMyhome());
        groupHelper.wd.findElement(By.name("mobile")).click();
        groupHelper.wd.findElement(By.name("mobile")).clear();
        groupHelper.wd.findElement(By.name("mobile")).sendKeys(contactData.getMymobile());
        groupHelper.wd.findElement(By.name("work")).click();
        groupHelper.wd.findElement(By.name("work")).clear();
        groupHelper.wd.findElement(By.name("work")).sendKeys(contactData.getMywork());
        groupHelper.wd.findElement(By.name("fax")).click();
        groupHelper.wd.findElement(By.name("fax")).clear();
        groupHelper.wd.findElement(By.name("fax")).sendKeys(contactData.getMyfax());
        if (!groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
        }
        groupHelper.wd.findElement(By.name("address2")).click();
        groupHelper.wd.findElement(By.name("address2")).clear();
        groupHelper.wd.findElement(By.name("address2")).sendKeys("123");
        groupHelper.wd.findElement(By.name("phone2")).click();
        groupHelper.wd.findElement(By.name("phone2")).clear();
        groupHelper.wd.findElement(By.name("phone2")).sendKeys("123");
        groupHelper.wd.findElement(By.name("notes")).click();
        groupHelper.wd.findElement(By.name("notes")).clear();
        groupHelper.wd.findElement(By.name("notes")).sendKeys("123");
        groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        groupHelper.wd.findElement(By.linkText("home")).click();
    }

    public void addNewContact() {
        groupHelper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
