package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        addNewContact();
        fillContactForm(new ContactData("Ilya", "Badzhelidze", "Murmanovich", "nick", "title", "8-921-636-90-01", "123453453", "Reksoft", "8-921-636-90-01", "8-921-636-90-01", "8-921-636-90-01"));
    }


}
