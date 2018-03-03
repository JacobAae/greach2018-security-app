package net.grydeske.security

class HonorRollController {

    def index(String name) {
        if( !session.students) {
            session.students = ['Paul', 'Guillaume', 'Cedric', 'Jochen']
        }
        if( name) {
            session.students << name
        }
        [honorRoll: session.students]
    }
}
