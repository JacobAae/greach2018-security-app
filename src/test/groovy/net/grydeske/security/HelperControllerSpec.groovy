package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HelperControllerSpec extends Specification implements ControllerUnitTest<HelperController> {

    void "index redirects to sha1"() {
        when:
        controller.index()

        then:
        response.redirectUrl == '/helper/sha1'
    }

    void "sha1 calculates hash via service"() {
        setup:
        controller.hashingService = Mock(HashingService)

        when:
        def model = controller.sha1('input')

        then:
        1 * controller.hashingService.calculateSha1('input') >> "SHA1 sum"
        model.text == 'input'
        model.sha1text == 'SHA1 sum'
    }

    void "md5 calculates hash via service"() {
        setup:
        controller.hashingService = Mock(HashingService)

        when:
        def model = controller.md5('input')

        then:
        1 * controller.hashingService.calculateMD5('input') >> "MD5 sum"
        model.text == 'input'
        model.md5text == 'MD5 sum'
    }

}
