package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class OtherLoginControllerSpec extends Specification implements ControllerUnitTest<OtherLoginController> {

    void "index uses service to check for access"() {
        setup:
        controller.otherLoginService = Mock(OtherLoginService)

        when:
        def model = controller.index('name','password')

        then:
        1 * controller.otherLoginService.isAllowedAccess('name','password') >> { true }
        model.name == 'name'
        model.password == 'password'
        model.isAllowedIn == true
    }
}
