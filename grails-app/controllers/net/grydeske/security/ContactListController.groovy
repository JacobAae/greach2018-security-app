package net.grydeske.security

class ContactListController {

    ContactListService contactListService

    def index() {
        [:]
    }

    def list() {
        [contactList:contactListService.contacts]
    }

    def save(Contact contact) {
        contactListService.saveContact(contact)
        redirect(action: 'list')
    }

    def delete(Contact contact) {
        contactListService.delete(contact)
        redirect(action: 'index')
    }
}
