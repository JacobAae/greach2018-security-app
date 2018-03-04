package net.grydeske.security

class BootStrap {

    def init = { servletContext ->
        if( !MyUser.count ) {
            new MyUser(
                    username: 'Kotlin',
                    password: 'Very Secure Password'
            ).save()

            MyUser.withSession {
                it.flush()
                it.clear()
            }
        }
    }
    def destroy = {
    }
}
