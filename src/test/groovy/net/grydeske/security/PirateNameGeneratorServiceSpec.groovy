package net.grydeske.security

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PirateNameGeneratorServiceSpec extends Specification implements ServiceUnitTest<PirateNameGeneratorService> {

    void "pirate service uses part of name and two pirate tokens"() {
        when:
        def pirateName = service.generatePirateName('Christopher')

        then:
        pirateName
        pirateName.startsWith('Christ')
        pirateName.split(' ').size() == 3
    }
}
