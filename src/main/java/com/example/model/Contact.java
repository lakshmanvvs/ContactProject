package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;


@Document(indexName = "contacts", type = "contact")
public class Contact {
    @Id
    private String id;
    private String name;
    private String company;
    private boolean favorite;
    private String smallImageURL;
    private String largeImageURL;

    public Contact(String id, String name, String company, boolean favorite, String smallImageURL, String largeImageURL,
                   Map<String, String> phone, Map<String, String> address) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.favorite = favorite;
        this.smallImageURL = smallImageURL;
        this.largeImageURL = largeImageURL;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public Map<String, String> getPhone() {
        return phone;
    }

    public void setPhone(Map<String, String> phone) {
        this.phone = phone;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    private Map<String, String> phone;
    private Map<String, String> address;

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", favorite=" + favorite +
                ", smallImageURL='" + smallImageURL + '\'' +
                ", largeImageURL='" + largeImageURL + '\'' +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }
}
