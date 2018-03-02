package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ContactListControllerSpec extends Specification implements ControllerUnitTest<ContactListController> {

    void "controller uses service to retrieve contact list"() {
        setup:
        controller.contactListService = Mock(ContactListService)

        when:
        def model = controller.list()

        then:
        1 * controller.contactListService.contacts >> { [new Contact(name: 'demo')] }
        model.contactList.size() == 1
    }

    void "controller uses service to save and then redirects to list"() {
        setup:
        controller.contactListService = Mock(ContactListService)

        when:
        controller.save(new Contact())

        then:
        1 * controller.contactListService.saveContact(_)
        response.redirectUrl == '/contactList/list'
    }

    void "controller uses service to delete and then redirects to list"() {
        setup:
        controller.contactListService = Mock(ContactListService)

        when:
        controller.delete(new Contact())

        then:
        1 * controller.contactListService.delete(_)
        response.redirectUrl == '/contactList/index'
    }
}
