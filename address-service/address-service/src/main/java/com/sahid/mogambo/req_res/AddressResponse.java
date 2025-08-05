package com.sahid.mogambo.req_res;

import com.sahid.mogambo.entity.Address;

public class AddressResponse {


    private long addressId;
    private String city;
    private String street;

    public AddressResponse(Address address){
        this.addressId = address.getId();
        this.city = address.getCity();
        this.street = address.getStreet();
    }


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
