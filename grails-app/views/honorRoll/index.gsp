<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="honorroll.title"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="honorroll.title"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <h2>Honor Students</h2>
                <ul style="margin-left: 15px;">
                    <g:each in="${honorRoll}" var="name">
                        <li>${name}</li>
                    </g:each>
                </ul>

                <div class="hidden">
                    <h3>Add Honor Student</h3>
                    <g:form action="index" method="POST">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </g:form>

                </div>

            </div>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>
                <p>Can you add another student to the Honor Roll?</p>


                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Check the sourcecode.</div>
                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">Is something hidden, that you can use?</div>
                <br>
            </div>
        </section>
    </div>
</div>

</body>
</html>