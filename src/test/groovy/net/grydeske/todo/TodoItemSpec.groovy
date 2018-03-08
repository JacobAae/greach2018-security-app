package net.grydeske.todo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TodoItemSpec extends Specification implements DomainUnitTest<TodoItem> {

    void "todo cannot be blank"() {
        expect:
        !new TodoItem(todo: '').validate(['todo'])
    }
}
