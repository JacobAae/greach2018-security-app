package net.grydeske.security

class PirateNameGeneratorController {

    PirateNameGeneratorService pirateNameGeneratorService

    def index(String name) {
        String pirateName = pirateNameGeneratorService.generatePirateName(name)

        String pirateText = "<h3>${name}</h3>"

        [name: "<strong>${name}</strong>", pirateName:pirateName, pirateText: pirateText]
    }
}
