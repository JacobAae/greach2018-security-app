<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="pirate.name.generator"/></title>
</head>

<body>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1><g:message code="pirate.name.generator"/></h1>
        </section>

        <div class="row">
            <section class="col-lg-8">
                <div class="well">
                    <g:form action="index" method="POST">
                        <div class="form-group">
                            <label for="name">Your Current Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </g:form>
                </div>

                <br>

                <g:if test="${pirateName}">
                    <div class='well'>
                        <p> Hello Matey, you can now drop your current name: ${raw(name)} and instead call yourself:
                        </p>
                        <h2> ${raw(pirateName)}</h2>
                    </div>
                </g:if>
            </section>
            <section class="col-lg-4">
                <div class="well instructions">
                    <h2>Instructions</h2>

                    <p>The input is not validated. This opens up the application to cross site scripting.</p>

                    <a href="#" class="hint"><strong>Hint 1:</strong></a>
                    <div style="display: none;">Try to include a script in the name input </div>

                    <br>

                    <a href="#" class="hint"><strong>Hint 2:</strong></a>
                    <div style="display: none;">Use something similar to &lt;script&gt;alert('vulnerable');&lt;/script&gt;</div>
                </div>
            </section>
        </div>
    </div>

</body>
</html>