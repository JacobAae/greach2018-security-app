<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="dnslookup.title"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="dnslookup.title"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <g:form action="index" method="POST">
                    <div class="form-group">
                        <label for="website">Website</label>
                        <input type="text" class="form-control" id="website" name="website" placeholder="Website url">
                    </div>
                    <g:hiddenField id="command" name="command" value=""/>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </g:form>
            </div>


            <g:if test="${result}">
                <div class='well'><strong>Result of ${command}</strong>
                    <pre>
                        ${result}
                    </pre>
                </div>
            </g:if>


        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>

                <p>Can you use this to gain knowledge on the files on the server?</p>

                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Try to check what is submitted, to do more </div>

                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;"><em>ls</em> lists files in a directory;</div>

                <br>

                <a href="#" class="hint"><strong>Hint 3:</strong></a>
                <div style="display: none;">Try using: <pre>?command=ls%20/tmp in the url</pre></div>



            </div>
        </section>
    </div>
</div>

<script>
    $("form").on('submit', function() {
        var website = $("#website").val();
        $("#command").val("nslookup " + website);
        return true;
    });
</script>

</body>
</html>