package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {


    @Test
    public void testModificationContact() throws Exception {

        app.gotoContactPage();
        app.chooseContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Ilya", "Badzhelidze", "Murmanovich", "nick", "title", "8-921-636-90-01", "123453453", "Reksoft", "8-921-636-90-01", "8-921-636-90-01", "8-921-636-90-01", null), false);
        app.getContactHelper().submitContactCreation("//div[@id='content']/form/input[22]");


    }
}

