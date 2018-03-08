package net.grydeske.todo

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class UserServiceSpec extends Specification implements ServiceUnitTest<UserService>, DataTest {

    void "splitRoles divides comma separated string into tokens"() {
        expect:
        service.splitRoles('ROLE_USER,ROLE_ADMIN') == ['ROLE_USER', 'ROLE_ADMIN']
    }
}
