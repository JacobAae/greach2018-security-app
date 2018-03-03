<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="sha1.calculator"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="sha1.calculator"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <g:form action="sha1" method="POST">
                    <div class="form-group">
                        <label for="text">Text</label>
                        <input type="text" class="form-control" id="text" name="text" placeholder="Text to calculate SHA1 for" value="${text}">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </g:form>

            </div>


            <g:if test="${text && sha1text}">
                <h1>The SHA-1-sum of '${raw(text)}' is '${sha1text}'</h1>
            </g:if>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>

                <p>This is just a helper being able to calculate SHA-1 Hash of a string</p>
            </div>
        </section>
    </div>
</div>


</body>
</html>