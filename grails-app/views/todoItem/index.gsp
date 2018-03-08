<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'todoItem.label', default: 'TodoItem')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
            </ul>
        </div>
        <div id="list-todoItem" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <section class="row">
                    <table class="table table-responsive table-bordered">
                        <thead>
                        <th>Task</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                        </thead>
                        <tbody>
                        <g:each in="${todoItemList}" var="item">
                            <tr>
                                <td>${raw(item.todo)}</td>
                                <td><g:link action="edit" id="${item.id}" class='btn btn-xs btn-primary'>Edit</g:link></td>
                                <td>
                                    <g:form action="delete" id="${item.id}" method="Delete">
                                        <g:submitButton name="Delete" class='btn btn-xs btn-danger'/>
                                    </g:form>
                                </td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
            </section>

            <div class="row">
                    <div class="pagination">
                        <g:paginate total="${todoItemCount ?: 0}" />
                    </div>

            </div>
        </div>
    </body>
</html>