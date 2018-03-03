package net.grydeske.security

import grails.testing.web.taglib.TagLibUnitTest
import spock.lang.Specification

class SessionLoginTagLibSpec extends Specification implements TagLibUnitTest<SessionLoginTagLib> {

    void "setSessionCookie outputs nothing if no sessionId specified"() {
        expect:
        tagLib.setSessionCookie(sessionId:sessionId) == ''

        where:
        sessionId << [null, '']
    }

    void "setSessionCookie outputs script setting cookie if a sessionId specified"() {
        expect:
        tagLib.setSessionCookie(sessionId:'someId') == '<script>document.cookie="mySessionID=someId";</script>'
    }

    void "showAlreadyLoggedIn outputs nothing if not already logged in"() {
        expect:
        tagLib.showAlreadyLoggedIn(alreadyLoggedIn:false) == ''
    }

    void "showAlreadyLoggedIn outputs text if alreadyLoggedIn is true"() {
        expect:
        tagLib.showAlreadyLoggedIn(alreadyLoggedIn:true, sessionId: 'c3687ab9880c26dfe7ab966a8a1701b5e017c2ff').toString() == '''\
<div class='alert alert-success' role='alert'>Already logged in as Paul!</div><br><div class="panel panel-default">
                <div class="panel-heading">The Secret of <strong>Paul</strong> is:</div>
                <div class="panel-body">The joke Paul knows is this:<br>Why do vampires believe everything you tell them?<br><em>Because they're suckers!</em></div>
            </div>'''
    }

    void "showWelcomeAtLogin outputs nothing if not already logged in"() {
        expect:
        tagLib.showWelcomeAtLogin(alreadyLoggedIn:false) == ''
    }

    void "showWelcomeAtLogin outputs text if alreadyLoggedIn is true"() {
        expect:
        tagLib.showWelcomeAtLogin(firstLogin: true, sessionId: 'c3687ab9880c26dfe7ab966a8a1701b5e017c2ff').toString() == '''\
<div class='alert alert-success' role='alert'>Login successful as Paul!</div><br><div class="panel panel-default">
                <div class="panel-heading">The Secret of <strong>Paul</strong> is:</div>
                <div class="panel-body">The joke Paul knows is this:<br>Why do vampires believe everything you tell them?<br><em>Because they're suckers!</em></div>
            </div>'''
    }
}

