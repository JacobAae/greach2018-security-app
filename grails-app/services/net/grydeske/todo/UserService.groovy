package net.grydeske.todo

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    TodoUser createUser(String username, String password, String roles) {
        TodoUser user = new TodoUser(username: username, password: password)
        user.save()

        if( !user.hasErrors()) {
            getRoles(roles).each {
                TodoUserTodoRole.create user, it
            }
        }
        user
    }

    List<TodoRole> getRoles(String roles) {
        if( !roles ) {
            return []
        }
        List<String> tokens = splitRoles(roles)
        if( tokens) {
            TodoRole.findAllByAuthorityInList(tokens)
        } else {
            []
        }
    }

    List<String> splitRoles(String roles) {
        roles.split(',')
    }
}
