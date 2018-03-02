<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="security.fail"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="security.fail"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <asset:image src="security-fail.jpg"/>


            </div>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>
                <p>One of the components this page uses has a known security issue, that can be used for XSS.</p>
                <p>Can you find it and explain what the problem was?</p>

                <p>Some browsers have fixed this with XSS prevention.</p>


                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Look at the source code, and see what is being used</div>

                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">This link may help: <a href="http://www.cvedetails.com/cve/CVE-2011-4969/" target="_blank">CVE-2011-4969</a> </div>
                <br>

                <a href="#" class="hint"><strong>Hint 3:</strong></a>
                <div style="display: none;">This link may help too: <a href="http://blog.mindedsecurity.com/2011/07/jquery-is-sink.html" target="_blank">jQuery is a Sink!</a> </div>
                <br>
                <a href="#" class="hint"><strong>Hint 4:</strong></a>
                <div style="display: none;">Try to append tomething like this to the url: <strong>#&lt;img src=x onerror=alert(42)&gt;</strong>
                    Chrome might be a good choise of browser for this.
                </div>


            </div>
        </section>
    </div>
</div>

<script>

    $(document).ready(function(){
        try {
            console.debug("Trying");
            $(location.hash);
            // Could do some navigation with this
        } catch(e) {
            console.debug(e);
        }
    })
</script>


</body>
</html>