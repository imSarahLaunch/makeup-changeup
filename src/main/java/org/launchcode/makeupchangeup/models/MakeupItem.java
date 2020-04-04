package org.launchcode.makeupchangeup.models;

import javax.validation.constraints.NotBlank;

public class MakeupItem {

    @NotBlank(message = "Name is required.")
    private String name;

    private String purchaseDate;

    public MakeupItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
