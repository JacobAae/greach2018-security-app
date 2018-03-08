package net.grydeske.security

import net.grydeske.todo.TodoItem
import net.grydeske.todo.TodoRole
import net.grydeske.todo.TodoUser
import net.grydeske.todo.TodoUserTodoRole

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

        if( !TodoUser.count) {
            def userRole = new TodoRole(authority: 'ROLE_USER').save()
            def adminRole = new TodoRole(authority: 'ROLE_ADMIN').save()
            def testUser1 = new TodoUser(username: 'me', password: 'password').save()
            def testUser2 = new TodoUser(username: 'you', password: 'password').save()

            TodoUserTodoRole.create testUser1, userRole
            TodoUserTodoRole.create testUser2, userRole

            TodoUserTodoRole.withSession {
                it.flush()
                it.clear()
            }

            15.times {
                new TodoItem( todo: "Todo for user 'me': $it", owner: testUser1).save()
                new TodoItem( todo: "Todo for user 'you': $it", owner: testUser2).save()
            }
            TodoItem.withSession {
                it.flush()
                it.clear()
            }


        }
    }
    def destroy = {
    }
}
