package com.sahid.mogambo.service;

import com.sahid.mogambo.entity.Address;
import com.sahid.mogambo.jpa.AddressRepository;
import com.sahid.mogambo.req_res.AddressResponse;
import com.sahid.mogambo.req_res.CreateAddressRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private static final Logger log = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        log.info("Inside createAddress method ");
        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());
        addressRepository.save(address);
        return new AddressResponse(address);
    }

    public AddressResponse getById(long id) {
        log.info("Inside getById method");
        Address address  = addressRepository.findById(id).get();
        return new AddressResponse(address);
    }
}
