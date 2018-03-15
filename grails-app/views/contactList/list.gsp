<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="contact.list"/></title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="contact.list"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <table class="table table-responsive table-bordered">
                    <thead>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>&nbsp;</th>
                    </thead>
                    <tbody>
                    <g:each in="${contactList}" var="contact">
                        <tr>
                            <td>${raw(contact.name)}</td>
                            <td>${contact.email}</td>
                            <td>${contact.phone}</td>
                            <td><g:link action="delete" id="${contact.id}" class='btn btn-xs btn-danger'>Delete</g:link></td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <g:link action="index" class="btn btn-default">Back to form</g:link>


            </div>
        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <g:render template="instructions"/>
            </div>
        </section>
    </div>
</div>

</body>
</html>