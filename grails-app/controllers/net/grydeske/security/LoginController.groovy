package net.grydeske.security

class LoginController {

    HashingService hashingService

    def index() {
        String sessionId = ''
        boolean alreadyLoggedIn = false
        boolean firstLogin = false
        def sessionCookie = request.cookies.find { it.name == 'mySessionID'}
        if( sessionCookie && sessionCookie.value ) {
            sessionId =  sessionCookie.value
            alreadyLoggedIn = true
        }
        if(params.name == 'Guillaume' && params.password == 'password1234') {
            sessionId = hashingService.calculateSha1(params.name)
            firstLogin = true
        }
        [sessionId:sessionId, alreadyLoggedIn: alreadyLoggedIn, firstLogin: firstLogin, name: params.name, password: params.password]
    }

}
