package net.grydeske.todo

import grails.gorm.services.Service

@Service(TodoItem)
interface TodoItemService {

    TodoItem get(Serializable id)

    List<TodoItem> findAllByOwner(TodoUser owner, Map args)

    Long countByOwner(TodoUser owner)

    void delete(Serializable id)

    TodoItem save(TodoItem todoItem)

}