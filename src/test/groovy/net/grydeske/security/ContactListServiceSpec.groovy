package net.grydeske.security

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ContactListServiceSpec extends Specification implements ServiceUnitTest<ContactListService>, DataTest {

    void setupSpec() {
        mockDomain Contact
    }

    void "saveContact will persist valid contact"() {
        when:
        service.saveContact(new Contact(name: 'Homer'))

        then:
        Contact.count == old(Contact.count) + 1
    }

    void "getContacts will retrieve list of contacts"() {
        setup:
        3.times {
            new Contact(name: "Bart $it").save(failOnError: true)
        }

        expect:
        service.contacts.size() == 3
    }

    void "delete will remove contact"() {
        setup:
        Contact contact = new Contact(name: "Lisa").save(failOnError: true)

        when:
        service.delete(contact)

        then:
        noExceptionThrown()
    }
}
