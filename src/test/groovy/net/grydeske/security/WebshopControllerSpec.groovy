package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class WebshopControllerSpec extends Specification implements ControllerUnitTest<WebshopController> {

    void "index returns the right model"() {
        setup:
        params.students = 42
        params.discount = "Some discount"

        when:
        def model = controller.index()

        then:
        model.students == 42
        model.discount == "Some discount"
    }

    void "flash is set correct"() {
        when:
        params.discount = discount
        controller.index()

        then:
        flash.message == message
        flash.error == error

        where:
        discount      | message                                                    | error
        'No thanks'   | null                                                       | "You don't like the near free discount?"
        'MuchTooNice' | 'Congrats - you have a discount code, and it is 90% of :)' | null
    }
}
