package net.grydeske.security

import groovy.transform.ToString

@ToString
class Contact {

    String name
    String email
    String phone

    static constraints = {
        name maxSize: 256
        email nullable: true
        phone nullable: true
    }
}
