package org.acme;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.RandomStringUtils;

public class Order {
    @NotNull
    private String id;

    @NotNull
    private String firstName; 

    @NotNull
    private String lastName; 

    @NotNull
    //@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}")
    private String email; 

    private String street;

    private String streetNumber;
    
    private String area;

    private String zipcode;
    
    @NotNull
    private String city;

    @NotNull
    private ArrayList<String> paymentMethods;

    private String trackingcode;

    public String getTrackingcode() {
        return this.trackingcode;
    }

    public void setTrackingcode(String trackingcode) {
        this.trackingcode = trackingcode;
    }

    public void computeTrackingcode(){
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        this.setTrackingcode(generatedString);
    }

    public Order() {
    }

    public Order(String id, String firstName, String lastName, String email, String street, String streetNumber, String area, String zipcode, String city, ArrayList<String> paymentMethods) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.streetNumber = streetNumber;
        this.area = area;
        this.zipcode = zipcode;
        this.city = city;
        this.paymentMethods = paymentMethods;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getPaymentMethods() {
        return this.paymentMethods;
    }

    public void setPaymentMethods(ArrayList<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", street='" + getStreet() + "'" +
            ", streetNumber='" + getStreetNumber() + "'" +
            ", area='" + getArea() + "'" +
            ", zipcode='" + getZipcode() + "'" +
            ", city='" + getCity() + "'" +
            ", paymentMethods='" + getPaymentMethods() + "'" +
            "}";
    }


}
