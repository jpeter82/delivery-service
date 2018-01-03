package com.peanuts.delivery.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressDao {

    @Autowired
    private AddressRepository addressRepository;

}
