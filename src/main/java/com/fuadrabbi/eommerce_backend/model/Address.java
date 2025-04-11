package com.fuadrabbi.eommerce_backend.model;

import jakarta.persistence.*;

//Address for the user
@Entity
@Table(name = "address")
public class Address {

    //Unique id for the address.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    //The first line of address.
    @Column(name = "address_line_1", nullable = false, length = 512)
    private String addressLine1;
    // The second line of address.
    @Column(name = "address_line_2", length = 512)
    private String addressLine2;
    // The city of the address.
    @Column(name = "city", nullable = false)
    private String city;
    // The country of the address.
    @Column(name = "country", nullable = false, length = 75)
    private String country;
    // The user the address is associated with.
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private LocalUser user;


    public LocalUser getUser() {
        return user;
    }


    public void setUser(LocalUser user) {
        this.user = user;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine2() {
        return addressLine2;
    }


    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }


    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}