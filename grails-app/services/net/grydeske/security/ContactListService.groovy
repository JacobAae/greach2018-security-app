package net.grydeske.security

import grails.gorm.transactions.Transactional

@Transactional
class ContactListService {

    void saveContact(Contact contact) {
        contact.save(flush:true)
    }

    List<Contact> getContacts(){
        Contact.list()
    }

    void delete(Contact contact) {
        contact.delete(flush: true)
    }
}
