package net.grydeske.security

import java.security.MessageDigest

class HashingService {

    String calculateSha1(String input) {
        if(!input) {
            return ''
        }
        MessageDigest.getInstance("sha1").digest(input.bytes).encodeHex().toString().padLeft(40, '0')
    }

    String calculateMD5(String input) {
        if(!input) {
            return ''
        }
        MessageDigest.getInstance("md5").digest(input.bytes).encodeHex().toString()
    }

}
