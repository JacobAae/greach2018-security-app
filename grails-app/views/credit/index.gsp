<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="credits.title"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="credits.title"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">
            <div class="well">

                <h2>Thank you for trying out this framework</h2>

                <p>You will shortly be redirected to the homepage of the creator of it</p>
                <p> Redirecting in <span id="countdown">15</span> seconds</p>

                <script>
                    function countdown() {
                        window.setTimeout(function(){
                            var time = $('#countdown').html()
                            if( time > 0) {
                                $('#countdown').html(time-1);
                                countdown();
                            } else {
                                window.location.href = "${url}";
                            }
                        }, 1000);
                    }

                    $(document).ready( function() {
                        countdown();
                    })
                </script>



            </div>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>

                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Look at the url</div>

                <br/>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">The input is not validated. You should be able to create a url that could send people to fx. groovy-lang.org.</div>


            </div>
        </section>
    </div>
</div>

</body>
</html>