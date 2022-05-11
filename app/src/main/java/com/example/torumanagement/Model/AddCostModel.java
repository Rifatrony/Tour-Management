package com.example.torumanagement.Model;

public class AddCostModel {

    String reason, date, amount, id;

    public AddCostModel(String reason, String date, String amount, String id) {
        this.reason = reason;
        this.date = date;
        this.amount = amount;
        this.id = id;
    }

    public AddCostModel() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
