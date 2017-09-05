package bean;

public class person {
    private String name;
    private String phone;
    private String mail;

    public person(){}
    public person(String name) {
        this.name = name;
    }
    public person(String name,String phone,String mail) {
        this(name);
        this.phone = phone;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
