package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CreditControllerSpec extends Specification implements ControllerUnitTest<CreditController> {

    void "index passes input url as parameter to view"() {
        expect:
        controller.index('groovy-lang.org').url == 'groovy-lang.org'
    }
}
