<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="todo.app.signup" default="Signup"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="todo.app.login" default="Signup"/></h1>

        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>

    </section>

    <div class="row">
        <section class="col-lg-12">

            <div class="well">

                <div id="login">
                    <div class="inner">
                        <g:form action="createUser" method="POST" autocomplete="off">
                            <div class="form-group">
                                <label for="username">Name</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password"">
                            </div>
                            <g:hiddenField name="roles" value="ROLE_USER"/>
                            <button type="submit" class="btn btn-primary">Signup</button>
                        </g:form>
                    </div>
                </div>

            </div>
            <br>

        </section>
    </div>
</div>

</body>
</html>