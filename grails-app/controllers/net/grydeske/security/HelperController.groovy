package net.grydeske.security

class HelperController {

    HashingService hashingService

    def index() {
        redirect(action: 'sha1')
    }

    def sha1(String text) {
        [text: text, sha1text: hashingService.calculateSha1(text)]
    }

    def md5(String text) {
        [text: text, md5text: hashingService.calculateMD5(text)]
    }
}
