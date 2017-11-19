package com.example.service;


import com.example.model.Contact;
import com.example.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IcontactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public Iterable<Contact> findAll() {
        return null;
    }

    @Override
    public Contact findOne(String id) {
        return null;
    }

    @Override
    public List<Contact> findByCompany(String company) {
        return null;
    }
}
