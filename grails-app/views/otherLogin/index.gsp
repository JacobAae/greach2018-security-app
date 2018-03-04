<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="sql.injection.login.title"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="sql.injection.login.title"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <g:form action="index" method="POST">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${name}">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="${password}">
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </g:form>
            </div>


            <g:if test="${isAllowedIn}">
                <div class='alert alert-success' role='alert'>
                    Login successful!
                </div>

                <br/>

                <div class="panel panel-default">
                    <div class="panel-heading">The Secret of this page is:</div>
                    <div class="panel-body">
                        A SQL Query walks into a bar. <br/>
                        In one corner of the bar are two tables. <br/>
                        The Query walks up to the tables and asks:<br/>
                        - Mind if I join you?
                    </div>
                </div>
            </g:if>




        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>

                <p>The input is not properly checked and validated.
                This opens up the application to SQL injection.</p>
                <p>Can you login without knowing the username and password?</p>

                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Try to modify the username input</div>

                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">If you use a single quote, do you get an output that give information away</div>

                <br>

                <a href="#" class="hint"><strong>Hint 3:</strong></a>
                <div style="display: none;">Use something similar to: <em>Noone' OR '1' = '1' OR '1' = '1 </em> </div>


            </div>
        </section>
    </div>
</div>

</body>
</html>