package com.example.kruzrtest.dataModel;

public class CardData {
    String name;
    String gender;
    String email;

    public CardData(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
