package com.example.service;

import com.example.model.Contact;

import java.util.List;

/**
 * Created by Laki on 11/19/2017.
 */
public interface IcontactService {

    Contact save(Contact contact);
    void delete(Contact contact);
    Iterable<Contact> findAll();
    Contact findOne(String id);
    List<Contact> findByCompany(String company);
}
