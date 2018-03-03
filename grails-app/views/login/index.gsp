<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="session.handling.login"/> </title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1><g:message code="session.handling.login"/></h1>
    </section>

    <div class="row">
        <section class="col-lg-8">

            <g:if test="${!firstLogin && !alreadyLoggedIn}">
                <div class="well">
                    <form action="index" method="POST">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${name}">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="${password}">
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
                <br>
            </g:if>

            <g:setSessionCookie sessionId="${sessionId}"/>

            <g:showWelcomeAtLogin firstLogin="${firstLogin}" sessionId="${sessionId}"/>

            <g:showAlreadyLoggedIn alreadyLoggedIn="${alreadyLoggedIn}" sessionId="${sessionId}"/>

        </section>
        <section class="col-lg-4">
            <div class="well instructions">
                <h2>Instructions</h2>
                <p>You have two users, Guillaume and Paul. The password for Guillaume is password1234</p>
                <p>Once you log in, you can see Guillaume's secret, but can you exploit the bad session management to also find Paul's secret?</p>


                <a href="#" class="hint"><strong>Hint 1:</strong></a>
                <div style="display: none;">Study how the session management is handled, once you log in.</div>
                <br>

                <a href="#" class="hint"><strong>Hint 2:</strong></a>
                <div style="display: none;">Study the cookie. You can see the values using the javascript console and <em>document.cookie</em>. </div>
                <br>

                <a href="#" class="hint"><strong>Hint 3:</strong></a>
                <div style="display: none;">The Helper tools are there for a reason.</div>
                <br>

                <a href="#" class="hint"><strong>Hint 4:</strong></a>
                <div style="display: none;">What is the SHA-1 hash of Guillaume? Can you set a new sessionId?.</div>
                <br>

                <a href="#" class="hint"><strong>Hint 5:</strong></a>
                <div style="display: none;">Try something like: document.cookie= "mySessionID=c3687ab9880c26dfe7ab966a8a1701b5e017c2ff"; in the js console.</div>
                <br>

            </div>
        </section>
    </div>
</div>

</body>
</html>