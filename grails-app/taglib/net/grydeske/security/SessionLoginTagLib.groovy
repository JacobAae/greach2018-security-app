package net.grydeske.security

class SessionLoginTagLib {
    static defaultEncodeAs = [setSessionCookie:'none']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def setSessionCookie = { attrs ->
        if( attrs.sessionId ) {
            out << """<script>document.cookie="mySessionID=${attrs.sessionId}";</script>"""
        }
    }

    def showAlreadyLoggedIn = { attrs ->
        boolean isAlreadyLoggedIn = attrs.alreadyLoggedIn
        String name = getNameFromSessionId(attrs.sessionId)
        if( isAlreadyLoggedIn && name ) {
            out << "<div class='alert alert-success' role='alert'>Already logged in as ${name}!</div>"

            out << "<br>"
            out << "${getSecret(name)}"
        }
    }

    def showWelcomeAtLogin = { attrs ->
        boolean firstLogin = attrs.firstLogin
        String name = getNameFromSessionId(attrs.sessionId)

        if( firstLogin && name) {
            out << "<div class='alert alert-success' role='alert'>Login successful as ${name}!</div>"
            out << "<br>"
            out << "${getSecret(name)}"
        }
    }

    private String getNameFromSessionId(String sessionId) {
        // Could have been a service lookup
        switch(sessionId) {
            case '5c4f46018d55b4e09ff273759956795adb399085':
                return 'Guillaume'
            case 'c3687ab9880c26dfe7ab966a8a1701b5e017c2ff':
                return 'Paul'
        }
    }

    private String getSecret(String name ) {
        String secret = getSecretForName(name)

        """<div class="panel panel-default">
                <div class="panel-heading">The Secret of <strong>${name}</strong> is:</div>
                <div class="panel-body">${secret}</div>
            </div>"""
    }

    private String getSecretForName(String name) {
        switch( name ) {
            case 'Guillaume':
                return "The joke Guillaume knows is this:<br>What's Forrest Gump's email password?<br><em>1forrest1</em>"
            case 'Paul':
                return "The joke Paul knows is this:<br>Why do vampires believe everything you tell them?<br><em>Because they're suckers!</em>"
        }
    }
}
