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
                <g:form action="save" method="POST">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone">
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                    <g:link action="list" class="btn btn-default">See Contacts</g:link>
                </g:form>
            </div>
        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>

                <p>The input is not validated. This opens up the application to cross site scripting.</p>

                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Try to include a script in the name input</div>

                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">Use something similar to &lt;script&gt;console.log('vulnerable');&lt;/script&gt;</div>


            </div>
        </section>
    </div>
</div>

<script>
    $("a.hint").on('click', function() {
        $(this).next('div').slideDown();
        return false;
    })
</script>

</body>
</html>