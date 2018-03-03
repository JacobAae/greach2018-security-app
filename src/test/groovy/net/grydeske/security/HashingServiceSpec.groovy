package net.grydeske.security

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class HashingServiceSpec extends Specification implements ServiceUnitTest<HashingService>{

    /*
    Commandline calculation:
    echo -n "That which should be hashed" | sha1sum | awk '{print $1}'
     */
    @Unroll
    void "calculateSha1 should calculate the hash value"() {
        expect:
        service.calculateSha1(input) == output

        where:
        input           | output
        'Guillaume'     | '5c4f46018d55b4e09ff273759956795adb399085'
        'Paul'          | 'c3687ab9880c26dfe7ab966a8a1701b5e017c2ff'
    }


    /*
    Commandline calculation:
    echo -n "That which should be hashed" | sha1sum | awk '{print $1}'
     */
    @Unroll
    void "calculateMD5 should calculate the hash value"() {
        expect:
        service.calculateMD5(input) == output

        where:
        input           | output
        'Guillaume'     | 'e657bb4805a678895d4ff7594763157b'
        'Paul'          | 'c13e13da2073260c2194c15d782e86a9'
    }


}
