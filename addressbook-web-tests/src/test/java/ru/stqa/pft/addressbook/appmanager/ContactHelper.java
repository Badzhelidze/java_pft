package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
    protected final GroupHelper groupHelper = new GroupHelper();

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
}
