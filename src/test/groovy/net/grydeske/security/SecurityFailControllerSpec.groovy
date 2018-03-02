package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class SecurityFailControllerSpec extends Specification implements ControllerUnitTest<SecurityFailController> {

    void "index returns empty model"() {
        expect:
        controller.index() == [:]
    }
}
