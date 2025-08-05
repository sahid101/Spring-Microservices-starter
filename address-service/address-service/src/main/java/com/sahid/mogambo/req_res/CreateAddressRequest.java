package com.sahid.mogambo.req_res;

import lombok.Data;

@Data
public class CreateAddressRequest {

    private long addressId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private String city;
    private String street;
}
