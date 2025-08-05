package com.sahid.mogambo.controller;

import com.sahid.mogambo.req_res.AddressResponse;
import com.sahid.mogambo.req_res.CreateAddressRequest;
import com.sahid.mogambo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping()
    void ping(){

    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("getById/{id}")
    public AddressResponse getById(@PathVariable long id){
        return addressService.getById(id);
    }

}
