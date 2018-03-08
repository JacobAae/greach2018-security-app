package net.grydeske.todo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TodoItemServiceSpec extends Specification {

    TodoItemService todoItemService
    SessionFactory sessionFactory

    private Map setupData() {
        TodoUser user = new TodoUser(username: 'test', password: 'pw').save(flush: true, failOnError: true)
        new TodoItem(owner: user, todo: 'Do something 1').save(flush: true, failOnError: true)
        new TodoItem(owner: user, todo: 'Do something 2').save(flush: true, failOnError: true)
        TodoItem todoItem = new TodoItem(owner: user, todo: 'Do something 3').save(flush: true, failOnError: true)
        new TodoItem(owner: user, todo: 'Do something 4').save(flush: true, failOnError: true)
        new TodoItem(owner: user, todo: 'Do something 5').save(flush: true, failOnError: true)
        [item: todoItem.id, user: user.id]
    }

    void "test get"() {
        setupData()

        expect:
        todoItemService.get(2) != null
    }

    void "test list"() {
        setup:
        def ids = setupData()

        when:
        List<TodoItem> todoItemList = todoItemService.findAllByOwner(TodoUser.get(ids.user), [max: 2, offset: 2])

        then:
        todoItemList.size() == 2
        todoItemList.any { it.todo == 'Do something 3' }
    }

    void "test count"() {
        setup:
        def ids = setupData()

        expect:
        todoItemService.countByOwner(TodoUser.get(ids.user)) == 5
    }

    void "test delete"() {
        setup:
        def ids = setupData()

        expect:
        todoItemService.countByOwner(TodoUser.get(ids.user)) == 5

        when:
        todoItemService.delete(ids.item)
        sessionFactory.currentSession.flush()

        then:
        todoItemService.countByOwner(TodoUser.get(ids.user)) == 4
    }

    void "test save"() {
        setup:
        def ids = setupData()

        when:
        TodoItem todoItem = new TodoItem(owner: TodoUser.get(ids.user), todo: 'Something new')
        todoItemService.save(todoItem)

        then:
        todoItem.id != null
    }
}
