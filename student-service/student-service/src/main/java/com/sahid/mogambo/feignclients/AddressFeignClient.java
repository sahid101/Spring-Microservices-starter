package com.sahid.mogambo.feignclients;

import com.sahid.mogambo.req_res.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${address.service.url}", value = "address-feign-client", path = "/api/address")
public interface AddressFeignClient {

    @GetMapping("getById/{id}")
    public AddressResponse getById(@PathVariable long id);
}
