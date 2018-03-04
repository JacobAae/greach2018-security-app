package net.grydeske.security

class WebshopController {

    def index() {
        if( params.discount == 'MuchTooNice') {
            flash.message = "Congrats - you have a discount code, and it is 90% of :)"
        } else {
            if( params.students ) {
                flash.error = "You don't like the near free discount?"
            }
        }

        [students:params.students, discount:params.discount]
    }
}
