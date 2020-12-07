package com.medical.MedicalApp.model;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "section")
    private String section;
    @Column(name = "phone")
    private String phone;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "image")
    private String image;

    public doctor() {
        super();
    }

    public doctor(String fullName, String section, String phone, String login, String password, String image) {
        super();
        this.fullName = fullName;
        this.section = section;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.image = image;
    }
    
    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
