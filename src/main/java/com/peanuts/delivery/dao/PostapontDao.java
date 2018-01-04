package com.peanuts.delivery.dao;

import com.peanuts.delivery.repository.PostapontRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostapontDao {

    @Autowired
    private PostapontRepository postapontRepository;

}