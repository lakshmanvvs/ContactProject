package com.example.repository;

import com.example.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * The interface Contact repository.
 */
public interface ContactRepository extends ElasticsearchRepository<Contact, String> {

    /**
     * Find by company list.
     *
     * @param company the company
     * @return the list
     */
    List<Contact> findByCompany(String company);
    Page<Contact> findAll(Pageable pageable);
}
