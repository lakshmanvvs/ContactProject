package com.example.repository;

import com.example.model.Contact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ContactRepository extends ElasticsearchRepository<Contact, String> {

    List<Contact> findByCompany(String company);
}
