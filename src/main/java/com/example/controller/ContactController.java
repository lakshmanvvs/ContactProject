package com.example.controller;

import com.example.model.Contact;
import com.example.service.ContactService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "API to save the contact entity", nickname = "saveContact", consumes = "application/json",
            produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = String.class)})
    @RequestMapping(value = "/contactmgr/v1/contact", consumes = "application/json", produces = "application/json",
            method = RequestMethod.POST)
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        logger.info("API reached create method in controller");
        Contact contact1 = contactService.save(contact);
        return new ResponseEntity<>(contact1, HttpStatus.CREATED);
    }

    @ApiOperation(value = "API to get the contact by Id", nickname = "findContact", consumes = "application/json",
            produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class)})
    @RequestMapping(value = "/contactmgr/v1/contact/{id}", consumes = "application/json", produces = "application/json",
            method = RequestMethod.GET)
    public ResponseEntity<?> getContactById(@PathVariable String id) {
        logger.info("API reached get() method in controller");
        Contact contact1 = contactService.findOne(id);
        if (contact1 == null) {
            return new ResponseEntity<>("No contact found with " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contact1, HttpStatus.OK);
    }

    @RequestMapping(value = "/contactmgr/v1/contact/{company}", produces = "application/json",
             method = RequestMethod.GET)
    public ResponseEntity<?> getAllContacts(@PathVariable String company) {
        logger.info("API reached findAll() method in controller");

        return new ResponseEntity<>(contactService.findByCompany(company), HttpStatus.OK);
    }

    @ApiOperation(value = "API to delete the contact entity", nickname = "deleteContact", consumes = "application/json",
            produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Deleted Respurce", response = String.class)})
    @RequestMapping(value = "/contactmgr/v1/contact/{id}", consumes = "application/json", produces = "application/json",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContactById(@PathVariable String id) {
        logger.info("API reached delete() method in controller");
        Contact contact1 = contactService.findOne(id);
        if (contact1 == null) {
            return new ResponseEntity<>("No contact found with " + id, HttpStatus.NOT_FOUND);
        } else {
            contactService.deleteById(id);
        }

        return new ResponseEntity<>("Deleted Contact with id: " + id, HttpStatus.OK);
    }

    @ApiOperation(value = "API to update the contact entity", nickname = "updateContact", consumes = "application/json",
            produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success")})
    @RequestMapping(value = "/contactmgr/v1/contact/{id}", consumes = "application/json", produces = "application/json",
            method = RequestMethod.PATCH)
    public ResponseEntity<?> updateContact(@RequestBody Contact contact, @PathVariable String id) {
        logger.info("API reached update() method in controller");
        contactService.updateContact(contact, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
