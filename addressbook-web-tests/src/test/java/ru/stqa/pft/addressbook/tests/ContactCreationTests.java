package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        app.addNewContact();
        app.fillContactForm(new ContactData("Ilya", "Badzhelidze", "Murmanovich", "nick", "title", "8-921-636-90-01", "123453453", "Reksoft", "8-921-636-90-01", "8-921-636-90-01", "8-921-636-90-01"));
    }

}
