package ru.stqa.pft.adressbook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class GroupCreationTests {


  ChromeDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://127.0.0.1:8080/addressbook/group.php");

    login("user", "pass", By.xpath("//form[@id='LoginForm']/input[3]"), "admin", "secret");
  }

  private void login(String user, String pass, By xpath, String username, String password) {
    initGroupCreation(user);
    wd.findElement(By.name(user)).clear();
    wd.findElement(By.name(user)).sendKeys(username);
    initGroupCreation(pass);
    wd.findElement(By.name(pass)).clear();
    wd.findElement(By.name(pass)).sendKeys(password);
    wd.findElement(xpath).click();
  }

  @Test
  public void testGroupCreation(String test2) {
    gotoGroupPage("groups");
    initGroupCreation("new");
    login("group_name", "group_header", By.name("group_footer"), "test1", test2);
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("test3");
    initGroupCreation("submit");
    gotoGroupPage("group page");
  }

  private void initGroupCreation(String s) {
    wd.findElement(By.name(s)).click();
  }

  private void gotoGroupPage(String groups) {
    wd.findElement(By.linkText(groups)).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
  

  public static boolean isAlertPresent(ChromeDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
