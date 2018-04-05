package model;

import java.util.UUID;

public class Student {

    int studentId;
    String name;
    String cardNo;
    String personalNumericalCode;
    String address;
    String group;
    String username;
    String password;

    public Student() {
        this.studentId = UUID.randomUUID().hashCode();
        this.name = "";
        this.cardNo = "";
        this.personalNumericalCode = "";
        this.address = "";
        this.group = "";
        this.username = "";
        this.password = "";
    }

    public Student(String name, String cardNo, String personalNumericalCode, String address, String group, String username, String password) {
        this.studentId = UUID.randomUUID().hashCode();
        this.name = name;
        this.cardNo = cardNo;
        this.personalNumericalCode = personalNumericalCode;
        this.address = address;
        this.group = group;
        this.username = username;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setPersonalNumericalCode(String personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
