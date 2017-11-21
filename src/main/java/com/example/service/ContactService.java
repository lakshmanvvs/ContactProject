package com.example.service;


import com.example.model.Contact;
import com.example.repository.ContactRepository;
import com.example.vo.ContactUtil;
import com.google.gson.Gson;
import org.elasticsearch.action.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Contact service.
 */
@Service
public class ContactService implements IcontactService {

    private ContactRepository contactRepository;

    private ElasticsearchTemplate template;
    private Gson gson;

    /**
     * Sets contact repository.
     *
     * @param contactRepository the contact repository
     * @param template          the template
     * @param gson              the gson
     */
    @Autowired
    public void setContactRepository(ContactRepository contactRepository, ElasticsearchTemplate template,
                                     Gson gson) {
        this.contactRepository = contactRepository;
        this.template = template;
        this.gson = gson;
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteById(String id) {
        template.delete(ContactUtil.CONTACT_INDEX, ContactUtil.CONTACT_TYPE, id);
        template.refresh(ContactUtil.CONTACT_INDEX);
    }

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findOne(String id) {
        return contactRepository.findOne(id);
    }

    @Override
    public List<Contact> findByCompany(String company) {
        return contactRepository.findByCompany(company);
    }

    @Override
    public Page<Contact> findAllContacts(int page, int size) {
        return (Page<Contact>) contactRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public void updateContact(Contact contact, String id) {
       Contact contactToFind = contactRepository.findOne(id);
       if (contactToFind != null) {
           UpdateRequest updateRequest = new UpdateRequest();
           updateRequest.index(ContactUtil.CONTACT_INDEX);
           updateRequest.type(ContactUtil.CONTACT_TYPE);
           updateRequest.doc(gson.toJson(contact));
           final UpdateQuery updateQuery = new UpdateQueryBuilder().withId(id).withClass(Contact.class)
                   .withUpdateRequest(updateRequest).build();
           template.update(updateQuery);
           template.refresh(ContactUtil.CONTACT_INDEX);
       }
    }
}
