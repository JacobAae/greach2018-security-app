package net.grydeske.security

class DnsController {

    def index(String command) {
        String result = null
        if( command) {
            try {
                result = command.execute().text
            } catch(Exception e) {
                result = e.message
            }
        }
        [command: command, result: result]
    }
}
