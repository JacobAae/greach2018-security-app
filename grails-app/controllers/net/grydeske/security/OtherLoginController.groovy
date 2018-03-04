package net.grydeske.security

class OtherLoginController {

    OtherLoginService otherLoginService

    def index(String name, String password) {
        println "name=$name password=$password"

        def isAllowedIn = otherLoginService.isAllowedAccess(name,password)

        [name:name, password:password, isAllowedIn: isAllowedIn]
    }
}
