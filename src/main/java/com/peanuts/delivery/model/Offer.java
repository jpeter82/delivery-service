package com.peanuts.delivery.model;

import java.time.LocalDate;

public class Offer {

    private String name;
    private String cost;
    private Currency currency;
    private LocalDate deadline;

    public Offer() {
    }

    public Offer(String name, String cost, Currency currency, LocalDate deadline) {
        this.name = name;
        this.cost = cost;
        this.currency = currency;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

}
