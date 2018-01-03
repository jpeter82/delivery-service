package com.peanuts.delivery.controller;


import com.peanuts.delivery.dao.PostapontDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class DeliveryController {

    private PostapontDao postapontDao;

    public DeliveryController(PostapontDao postapontDao) {
        this.postapontDao = postapontDao;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String queryDeliveryOptions(Model model, HttpSession session) {
        String jsonResponse = null;
        return jsonResponse;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String saveOrder(Model model, HttpSession session) {
        String jsonResponse = null;
        return jsonResponse;
    }

}
