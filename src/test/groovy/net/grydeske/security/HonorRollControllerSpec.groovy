package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HonorRollControllerSpec extends Specification implements ControllerUnitTest<HonorRollController> {

    void "index delivers model with honor roll"() {
        expect:
        controller.index().honorRoll == ['Paul', 'Guillaume', 'Cedric', 'Jochen']
    }
}
