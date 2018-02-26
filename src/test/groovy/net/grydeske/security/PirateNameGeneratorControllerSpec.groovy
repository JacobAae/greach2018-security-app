package net.grydeske.security

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PirateNameGeneratorControllerSpec extends Specification implements ControllerUnitTest<PirateNameGeneratorController> {

    void "index uses service and returns correct model"() {
        setup:
        controller.pirateNameGeneratorService = Mock(PirateNameGeneratorService)

        when:
        params.name = "Margareth"
        def model = controller.index()

        then:
        1 * controller.pirateNameGeneratorService.generatePirateName("Margareth") >> { "Marga Pirate Name"}
        response.status == 200
        model.name
        model.pirateName
        model.pirateText
    }
}
