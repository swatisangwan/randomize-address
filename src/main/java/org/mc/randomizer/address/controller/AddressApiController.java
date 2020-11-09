package org.mc.randomizer.address.controller;

import org.mc.randomizer.address.model.Address;
import org.mc.randomizer.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AddressApiController implements AddressApi {

    private final AddressService addressService;

    @Autowired
    public AddressApiController(AddressService addressService) {
        this.addressService = addressService;
    }

    public ResponseEntity<Address> addressGet() {
        return new ResponseEntity<>(addressService.generateAddress(), HttpStatus.OK);
    }
}