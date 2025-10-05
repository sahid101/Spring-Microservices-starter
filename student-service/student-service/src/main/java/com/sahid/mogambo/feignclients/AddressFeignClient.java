package com.sahid.mogambo.feignclients;

import com.sahid.mogambo.req_res.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
Now this is a feign client not specific to address service,
but the api gateway, you can call any service.
*/
@FeignClient(value = "api-gateway")
public interface AddressFeignClient {

    @GetMapping("address-service/api/address/getById/{id}")
    public AddressResponse getById(@PathVariable long id);
}
