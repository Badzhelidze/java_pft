package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String myname;
    private final String mysurname;
    private final String mylastname;
    private final String mynick;
    private final String mytitle;
    private final String myhome;
    private final String myaddress;
    private final String mycompany;
    private final String mymobile;
    private final String mywork;
    private final String myfax;

    public ContactData(String myname, String mysurname, String mylastname, String mynick, String mytitle, String myhome, String myaddress, String mycompany, String mymobile, String mywork, String myfax) {
        this.myname = myname;
        this.mysurname = mysurname;
        this.mylastname = mylastname;
        this.mynick = mynick;
        this.mytitle = mytitle;
        this.myhome = myhome;
        this.myaddress = myaddress;
        this.mycompany = mycompany;
        this.mymobile = mymobile;
        this.mywork = mywork;
        this.myfax = myfax;
    }

    public String getMyname() {
        return myname;
    }

    public String getMysurname() {
        return mysurname;
    }

    public String getMylastname() {
        return mylastname;
    }

    public String getMynick() {
        return mynick;
    }

    public String getMytitle() {
        return mytitle;
    }

    public String getMyhome() {
        return myhome;
    }

    public String getMyaddress() {
        return myaddress;
    }

    public String getMycompany() {
        return mycompany;
    }

    public String getMymobile() {
        return mymobile;
    }

    public String getMywork() {
        return mywork;
    }

    public String getMyfax() {
        return myfax;
    }
}
