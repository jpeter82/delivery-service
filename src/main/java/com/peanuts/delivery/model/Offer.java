package com.peanuts.delivery.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Offer {

    private String name;
    private String cost;
    private Currency currency;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
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
