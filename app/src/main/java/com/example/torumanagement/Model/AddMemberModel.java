package com.example.torumanagement.Model;

public class AddMemberModel {

    String name, phone_number, amount, id;

    public AddMemberModel() {
    }

    public AddMemberModel(String name, String phone_number, String amount, String id) {
        this.name = name;
        this.phone_number = phone_number;
        this.amount = amount;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
