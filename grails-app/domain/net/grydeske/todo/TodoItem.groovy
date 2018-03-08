package net.grydeske.todo

class TodoItem {

    TodoUser owner

    String todo

    Date dateCreated
    Date lastUpdated

    static constraints = {
        todo blank: false
    }
}
