package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DnsControllerSpec extends Specification implements ControllerUnitTest<DnsController> {

    void "index returns nslookup result"() {
        when:
        def model = controller.index('nslookup groovy-lang.org')

        then:
        model
        model.command == 'nslookup groovy-lang.org'
        model.result
    }
}
