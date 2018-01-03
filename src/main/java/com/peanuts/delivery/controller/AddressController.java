package com.peanuts.delivery.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AddressController {

    private AddressDao addressDao;

    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
