package net.grydeske.todo

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
class TodoItemController {

    TodoItemService todoItemService
    SpringSecurityService springSecurityService
    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond todoItemService.findAllByOwner(springSecurityService.currentUser, params), model:[todoItemCount: todoItemService.countByOwner(springSecurityService.currentUser)]
    }

    def create() {
        respond new TodoItem(params), model: [owner: springSecurityService.currentUser]
    }

    def save(TodoItem todoItem) {
        if (todoItem == null) {
            notFound()
            return
        }

        try {
            todoItemService.save(todoItem)
        } catch (ValidationException e) {
            respond todoItem.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'todoItem.label', default: 'TodoItem'), todoItem.id])
                redirect action: 'index'
            }
            '*' { respond todoItem, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond todoItemService.get(id)
    }

    def update(TodoItem todoItem) {
        if (todoItem == null) {
            notFound()
            return
        }

        try {
            todoItemService.save(todoItem)
        } catch (ValidationException e) {
            respond todoItem.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'todoItem.label', default: 'TodoItem'), todoItem.id])
                redirect action: 'index'
            }
            '*'{ respond todoItem, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        todoItemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'todoItem.label', default: 'TodoItem'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured('permitAll')
    def signup() {
        [:]
    }

    @Secured('permitAll')
    def createUser() {
        TodoUser user = userService.createUser(params.username, params.password, params.roles)
        if( user.hasErrors() ) {
            flash.message = 'Problem creating user'
            redirect(action: 'signup')
        } else {
            flash.message = 'User created'
            redirect(controller: 'login', action: 'auth')
        }
    }

    @Secured('ROLE_ADMIN')
    def admin() {
        [:]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'todoItem.label', default: 'TodoItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
