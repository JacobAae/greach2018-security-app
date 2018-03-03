<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="md5.calculator"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="md5.calculator"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <form action="md5" method="POST">
                    <div class="form-group">
                        <label for="text">Text</label>
                        <input type="text" class="form-control" id="text" name="text" placeholder="Text to calculate MD5 for" value="${text}">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div>


            <g:if test="${text && md5text}">
                <h1>The MD5sum of '${raw(text)}' is '${md5text}'</h1>
            </g:if>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>

                <p>This is just a helper being able to calculate MD5 of a string</p>
            </div>
        </section>
    </div>
</div>


</body>
</html>