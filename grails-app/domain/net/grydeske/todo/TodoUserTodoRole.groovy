package net.grydeske.todo

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class TodoUserTodoRole implements Serializable {

	private static final long serialVersionUID = 1

	TodoUser todoUser
	TodoRole todoRole

	@Override
	boolean equals(other) {
		if (other instanceof TodoUserTodoRole) {
			other.todoUserId == todoUser?.id && other.todoRoleId == todoRole?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (todoUser) {
            hashCode = HashCodeHelper.updateHash(hashCode, todoUser.id)
		}
		if (todoRole) {
		    hashCode = HashCodeHelper.updateHash(hashCode, todoRole.id)
		}
		hashCode
	}

	static TodoUserTodoRole get(long todoUserId, long todoRoleId) {
		criteriaFor(todoUserId, todoRoleId).get()
	}

	static boolean exists(long todoUserId, long todoRoleId) {
		criteriaFor(todoUserId, todoRoleId).count()
	}

	private static DetachedCriteria criteriaFor(long todoUserId, long todoRoleId) {
		TodoUserTodoRole.where {
			todoUser == TodoUser.load(todoUserId) &&
			todoRole == TodoRole.load(todoRoleId)
		}
	}

	static TodoUserTodoRole create(TodoUser todoUser, TodoRole todoRole, boolean flush = false) {
		def instance = new TodoUserTodoRole(todoUser: todoUser, todoRole: todoRole)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(TodoUser u, TodoRole r) {
		if (u != null && r != null) {
			TodoUserTodoRole.where { todoUser == u && todoRole == r }.deleteAll()
		}
	}

	static int removeAll(TodoUser u) {
		u == null ? 0 : TodoUserTodoRole.where { todoUser == u }.deleteAll() as int
	}

	static int removeAll(TodoRole r) {
		r == null ? 0 : TodoUserTodoRole.where { todoRole == r }.deleteAll() as int
	}

	static constraints = {
	    todoUser nullable: false
		todoRole nullable: false, validator: { TodoRole r, TodoUserTodoRole ur ->
			if (ur.todoUser?.id) {
				if (TodoUserTodoRole.exists(ur.todoUser.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['todoUser', 'todoRole']
		version false
	}
}
