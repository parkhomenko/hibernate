package com.hillel.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAddress {

  @Column(name = "country")
  private String country;

  @Column(name = "city")
  private String city;

  @Column(name = "address")
  private String address;

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
