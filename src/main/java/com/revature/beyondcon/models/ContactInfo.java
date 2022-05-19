package com.revature.beyondcon.models;

public class ContactInfo {

    private int id;
    private int attendeeId;
    private String namePrefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nameSuffix;
    private String email;
    private String smAddress;
    private String city;
    private String state;
    private String zip;
    private String telephone;

    public ContactInfo() {
    }

    public ContactInfo(int id, int attendeeId, String namePrefix, String firstName, String middleName, String lastName, String nameSuffix, String email, String smAddress, String city, String state, String zip, String telephone) {
        this.id = id;
        this.attendeeId = attendeeId;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nameSuffix = nameSuffix;
        this.email = email;
        this.smAddress = smAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmAddress() {
        return smAddress;
    }

    public void setSmAddress(String smAddress) {
        this.smAddress = smAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", attendeeId=" + attendeeId +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nameSuffix='" + nameSuffix + '\'' +
                ", email='" + email + '\'' +
                ", smAddress='" + smAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

}
