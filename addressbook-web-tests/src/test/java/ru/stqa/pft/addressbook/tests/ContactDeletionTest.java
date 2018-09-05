package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {


    @Test
    public void testContactDeletion() throws Exception {

        app.gotoContactPage();
        app.chooseContact();
        app.getContactHelper().pressDelete();
        app.getContactHelper().deletionAcceptation();
        app.gotoContactPage();

    }


}
