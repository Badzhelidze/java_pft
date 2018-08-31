package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final NavigationHelper navigationHelper = new NavigationHelper();
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
        navigationHelper.wd = new ChromeDriver();
        navigationHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(navigationHelper.wd);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        navigationHelper.wd.get("http://localhost/addressbook/");
        navigationHelper.wd.findElement(By.name("user")).click();
        navigationHelper.wd.findElement(By.name("user")).clear();
        navigationHelper.wd.findElement(By.name("user")).sendKeys(username);
        navigationHelper.wd.findElement(By.name("pass")).click();
        navigationHelper.wd.findElement(By.name("pass")).clear();
        navigationHelper.wd.findElement(By.name("pass")).sendKeys(password);
        navigationHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        navigationHelper.wd.quit();
    }

    public void fillContactForm(ContactData contactData) throws Exception {
        navigationHelper.wd.findElement(By.name("firstname")).click();
        navigationHelper.wd.findElement(By.name("firstname")).clear();
        navigationHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getMyname());
        navigationHelper.wd.findElement(By.name("middlename")).click();
        navigationHelper.wd.findElement(By.name("middlename")).clear();
        navigationHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMysurname());
        navigationHelper.wd.findElement(By.name("lastname")).click();
        navigationHelper.wd.findElement(By.name("lastname")).clear();
        navigationHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getMylastname());
        navigationHelper.wd.findElement(By.name("nickname")).click();
        navigationHelper.wd.findElement(By.name("nickname")).clear();
        navigationHelper.wd.findElement(By.name("nickname")).sendKeys(contactData.getMynick());

        navigationHelper.wd.findElement(By.name("photo")).click();
        navigationHelper.wd.switchTo()
                .activeElement()
                .sendKeys(
                        "C:\\Users\\badzhelidze\\Downloads\\20180827_161606.png");

        navigationHelper.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        navigationHelper.wd.findElement(By.name("title")).click();
        navigationHelper.wd.findElement(By.name("title")).clear();
        navigationHelper.wd.findElement(By.name("title")).sendKeys(contactData.getMytitle());
        navigationHelper.wd.findElement(By.name("company")).click();
        navigationHelper.wd.findElement(By.name("company")).clear();
        navigationHelper.wd.findElement(By.name("company")).sendKeys(contactData.getMycompany());
        navigationHelper.wd.findElement(By.name("address")).click();
        navigationHelper.wd.findElement(By.name("address")).clear();
        navigationHelper.wd.findElement(By.name("address")).sendKeys(contactData.getMyaddress());
        navigationHelper.wd.findElement(By.name("home")).click();
        navigationHelper.wd.findElement(By.name("home")).clear();
        navigationHelper.wd.findElement(By.name("home")).sendKeys(contactData.getMyhome());
        navigationHelper.wd.findElement(By.name("mobile")).click();
        navigationHelper.wd.findElement(By.name("mobile")).clear();
        navigationHelper.wd.findElement(By.name("mobile")).sendKeys(contactData.getMymobile());
        navigationHelper.wd.findElement(By.name("work")).click();
        navigationHelper.wd.findElement(By.name("work")).clear();
        navigationHelper.wd.findElement(By.name("work")).sendKeys(contactData.getMywork());
        navigationHelper.wd.findElement(By.name("fax")).click();
        navigationHelper.wd.findElement(By.name("fax")).clear();
        navigationHelper.wd.findElement(By.name("fax")).sendKeys(contactData.getMyfax());
        if (!navigationHelper.wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            navigationHelper.wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
        }
        navigationHelper.wd.findElement(By.name("address2")).click();
        navigationHelper.wd.findElement(By.name("address2")).clear();
        navigationHelper.wd.findElement(By.name("address2")).sendKeys("123");
        navigationHelper.wd.findElement(By.name("phone2")).click();
        navigationHelper.wd.findElement(By.name("phone2")).clear();
        navigationHelper.wd.findElement(By.name("phone2")).sendKeys("123");
        navigationHelper.wd.findElement(By.name("notes")).click();
        navigationHelper.wd.findElement(By.name("notes")).clear();
        navigationHelper.wd.findElement(By.name("notes")).sendKeys("123");
        navigationHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        navigationHelper.wd.findElement(By.linkText("home")).click();
    }

    public void addNewContact() {
        navigationHelper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
