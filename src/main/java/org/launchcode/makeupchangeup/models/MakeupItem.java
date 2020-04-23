package org.launchcode.makeupchangeup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
public class MakeupItem {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name is required.")
    private String name;

    private String purchaseDate;

    private String expiration;

    private String expires;

    public MakeupItem(String name, String purchaseDate, String expiration, String expires) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.expiration = expiration;
        this.expires = expires;
    }

    public MakeupItem() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeupItem that = (MakeupItem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
