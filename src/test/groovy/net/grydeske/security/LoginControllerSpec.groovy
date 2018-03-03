package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

import javax.servlet.http.Cookie

class LoginControllerSpec extends Specification implements ControllerUnitTest<LoginController> {

    void "index passes name and password to view"() {
        when:
        params.name = 'Graeme'
        params.password = "secret"
        def model = controller.index()

        then:
        model.name == "Graeme"
        model.password == "secret"
    }

    void "index sets sessionId and alreadyLoggedIn if sessionCookie is present"() {
        when:
        def model = controller.index()

        then:
        !model.sessionId

        when:
        Cookie cookie = new Cookie("mySessionID", "1234")
        request.cookies = [cookie].toArray()
        model = controller.index()

        then:
        model.sessionId == "1234"
        model.alreadyLoggedIn == true
    }

    void "index sets first login if username and password is correct"() {
        setup:
        controller.hashingService = Mock(HashingService)

        when:
        params.name = 'Guillaume'
        params.password = "password1234"
        def model = controller.index()

        then:
        1 * controller.hashingService.calculateSha1('Guillaume') >> "session id"
        model.sessionId == "session id"
        model.firstLogin == true
    }


}
