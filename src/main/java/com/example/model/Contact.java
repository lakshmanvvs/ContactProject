package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;


/**
 * The type Contact.
 */
@Document(indexName = "contacts", type = "contact")
public class Contact {
    @Id
    private String id;
    private String name;
    private String company;
    private boolean favorite;
    private String email;
    private String website;
    private String birthdate;
    private String smallImageURL;
    private String largeImageURL;

    /**
     * Instantiates a new Contact.
     */
    public Contact(){}

    /**
     * Instantiates a new Contact.
     *
     * @param id            the id
     * @param name          the name
     * @param company       the company
     * @param favorite      the favorite
     * @param smallImageURL the small image url
     * @param largeImageURL the large image url
     * @param phone         the phone
     * @param address       the address
     * @param email         the email
     * @param website       the website
     * @param birthdate     the birthdate
     */
    public Contact(String id, String name, String company, boolean favorite, String smallImageURL, String largeImageURL,
                   Map<String, String> phone, Map<String, Object> address, String email, String website, String birthdate) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.favorite = favorite;
        this.smallImageURL = smallImageURL;
        this.largeImageURL = largeImageURL;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.website = website;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets birthdate.
     *
     * @return the birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets birthdate.
     *
     * @param birthdate the birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Sets company.
     *
     * @param company the company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Is favorite boolean.
     *
     * @return the boolean
     */
    public boolean isFavorite() {
        return favorite;
    }

    /**
     * Sets favorite.
     *
     * @param favorite the favorite
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * Gets small image url.
     *
     * @return the small image url
     */
    public String getSmallImageURL() {
        return smallImageURL;
    }

    /**
     * Sets small image url.
     *
     * @param smallImageURL the small image url
     */
    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    /**
     * Gets large image url.
     *
     * @return the large image url
     */
    public String getLargeImageURL() {
        return largeImageURL;
    }

    /**
     * Sets large image url.
     *
     * @param largeImageURL the large image url
     */
    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public Map<String, String> getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(Map<String, String> phone) {
        this.phone = phone;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Map<String, Object> getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Map<String, Object> address) {
        this.address = address;
    }

    private Map<String, String> phone;
    private Map<String, Object> address;

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
