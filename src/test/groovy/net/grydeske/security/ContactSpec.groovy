package net.grydeske.security

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ContactSpec extends Specification implements DomainUnitTest<Contact> {

    void "name can be up to 256 characters"() {
        expect:
        new Contact(name: "x" * 256).validate()
        !new Contact(name: "x" * 257).validate()
    }
}
