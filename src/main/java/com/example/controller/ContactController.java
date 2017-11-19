package com.example.controller;

import com.example.model.Contact;
import com.example.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

  @RequestMapping(value = "/contactmgr/v1/contact", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> createContact(@RequestBody Contact contact) {
   logger.info("API reached create method in controller");
    contactService.save(contact);
   return new ResponseEntity<String>(HttpStatus.CREATED);
  }

}
