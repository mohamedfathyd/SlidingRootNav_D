package com.yarolegovich.slidingrootnav.sample.model;

import com.google.gson.annotations.SerializedName;

public class contact_home {
    @SerializedName("id")
    int id;
    @SerializedName("image")
    String image;
    @SerializedName("category")
    String category;
    @SerializedName("name")
    String name;
    @SerializedName("details")
    String details;
    @SerializedName("phone")
    String phone;
    @SerializedName("copon")
    String copon;
    @SerializedName("address")
    String address;
    @SerializedName("link")
    String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCopon() {
        return copon;
    }

    public void setCopon(String copon) {
        this.copon = copon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
