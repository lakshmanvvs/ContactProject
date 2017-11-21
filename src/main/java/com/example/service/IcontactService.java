package com.example.service;

import com.example.model.Contact;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * The interface Icontact service.
 */
public interface IcontactService {

    /**
     * Save contact.
     *
     * @param contact the contact
     * @return the contact
     */
    Contact save(Contact contact);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(String id);

    /**
     * Find all iterable.
     *
     * @return the iterable
     */
    Iterable<Contact> findAll();

    /**
     * Find one contact.
     *
     * @param id the id
     * @return the contact
     */
    Contact findOne(String id);

    /**
     * Find by company list.
     *
     * @param company the company
     * @return the list
     */
    List<Contact> findByCompany(String company);

    /**
     * Find all contacts page.
     *
     * @param page the page
     * @param size the size
     * @return the page
     */
    Page<Contact> findAllContacts(int page, int size);

    /**
     * Update contact.
     *
     * @param contact the contact
     * @param id      the id
     */
    void updateContact(Contact contact, String id);
}
