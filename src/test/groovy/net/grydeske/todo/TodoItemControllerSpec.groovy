package net.grydeske.todo

import grails.plugin.springsecurity.SpringSecurityService
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class TodoItemControllerSpec extends Specification implements ControllerUnitTest<TodoItemController>, DomainUnitTest<TodoItem> {

    def populateValidParams(params) {
        assert params != null

        params["owner.id"] = 1
        params["todo"] = "Remember something"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * findAllByOwner(_,_) >> []
            1 * countByOwner(_) >> 0
        }
        controller.springSecurityService = Mock(SpringSecurityService) {
            2 * getCurrentUser() >> { new TodoUser() }
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.todoItemList
        model.todoItemCount == 0
    }

    void "Test the create action returns the correct model"() {
        setup:
        controller.springSecurityService = Mock(SpringSecurityService)

        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        1 * controller.springSecurityService.currentUser >> { new TodoUser() }
        model.todoItem!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/todoItem/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * save(_ as TodoItem)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def todoItem = new TodoItem(params)
        todoItem.id = 1

        controller.save(todoItem)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/todoItem/index'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * save(_ as TodoItem) >> { TodoItem todoItem ->
                throw new ValidationException("Invalid instance", todoItem.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def todoItem = new TodoItem()
        controller.save(todoItem)

        then:"The create view is rendered again with the correct model"
        model.todoItem != null
        view == 'create'
    }

    void "Test the edit action with a null id"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * get(2) >> new TodoItem()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.todoItem instanceof TodoItem
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/todoItem/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * save(_ as TodoItem)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def todoItem = new TodoItem(params)
        todoItem.id = 1

        controller.update(todoItem)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/todoItem/index'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * save(_ as TodoItem) >> { TodoItem todoItem ->
                throw new ValidationException("Invalid instance", todoItem.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new TodoItem())

        then:"The edit view is rendered again with the correct model"
        model.todoItem != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/todoItem/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.todoItemService = Mock(TodoItemService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/todoItem/index'
        flash.message != null
    }
}






