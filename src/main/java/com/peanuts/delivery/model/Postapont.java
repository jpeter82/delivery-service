package com.peanuts.delivery.model;

import javax.persistence.*;

@Entity
public class Postapont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name="zipcode")
    private String zipcode;

    @Column(name = "address")
    private String address;

    @Column(name = "title")
    private String title;

    public Postapont() {
    }

    public Postapont(Long id, String city, String zipcode, String address, String title) {
        this.id = id;
        this.city = city;
        this.zipcode = zipcode;
        this.address = address;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
