package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) throws Exception {
        type(By.name("firstname"), (contactData.getMyname()));
        type(By.name("middlename"), (contactData.getMysurname()));
        type(By.name("lastname"), (contactData.getMylastname()));
        type(By.name("nickname"), (contactData.getMynick()));

        wd.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\badzhelidze\\Downloads\\20180827_161606.png");
        //wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        type(By.name("title"), (contactData.getMytitle()));
        type(By.name("company"), (contactData.getMycompany()));
        type(By.name("address"), (contactData.getMyaddress()));
        type(By.name("home"), (contactData.getMyhome()));
        type(By.name("mobile"), (contactData.getMymobile()));
        type(By.name("work"), (contactData.getMywork()));
        type(By.name("fax"), (contactData.getMyfax()));
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(contactData.getMyfax());
        //

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


        type(By.name("address2"), "123");
        type(By.name("phone2"), "123");
        type(By.name("notes"), "123");

    }

    public void returnHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void submitContactCreation(String buttonid) {
        wd.findElement(By.xpath(buttonid)).click();
    }

    public void editContact() {
        wd.findElement(By.xpath("//tr[.//td[text()='Ilya']]//img[@title='Edit']")).click();
    }

    public void pressDelete() {
        wd.findElement(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input")).click();
    }

    public void deletionAcceptation() {
        wd.switchTo().alert().accept();
    }
}

