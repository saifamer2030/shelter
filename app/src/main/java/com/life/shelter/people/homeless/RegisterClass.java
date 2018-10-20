package com.life.shelter.people.homeless;

/**
 * Created by AHMED MAGDY on 9/23/2018.
 */

public class RegisterClass {
    private String cemail;
    private String ccountry;
    private String ctype;
    private String WebSite;
    private String NumberPhone;



    public RegisterClass(String cemail, String ccountry, String ctype,String web,String NumberPhone) {
        this.cemail = cemail;
        this.ccountry = ccountry;
        this.ctype = ctype;
        this.WebSite=web;
        this.NumberPhone = NumberPhone;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCcountry() {
        return ccountry;
    }

    public void setCcountry(String ccountry) {
        this.ccountry = ccountry;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }


    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String Web) {
        this.WebSite = Web;
    }
    public String getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(String NumberPhone) {
        this.NumberPhone = NumberPhone;
    }
}
