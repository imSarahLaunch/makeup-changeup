package org.launchcode.makeupchangeup.models;

public class MakeupItem {

    private String name;

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
