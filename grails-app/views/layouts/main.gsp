<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>

    <g:if test="${controllerName == 'securityFail'}">
        <asset:javascript src="securityFail.js"/>
    </g:if>
    <g:else>
        <asset:javascript src="application.js"/>
    </g:else>

</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
		    <asset:image src="grails.svg" alt="Grails Logo"/>
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <g:message code="challenges"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="pirateNameGenerator" action="index"><g:message code="pirate.name.generator"/> </g:link></li>
                            <li><g:link controller="contactList" action="index"><g:message code="contact.list"/> </g:link></li>

                            <li><g:link controller="webshop" action="index"><g:message code="webshop.title"/> </g:link></li>

                            <li><g:link controller="securityFail" action="index"><g:message code="security.fail"/> </g:link></li>

                            <li><g:link controller="login" action="index"><g:message code="session.handling.login"/> </g:link></li>

                            <li><g:link controller="honorRoll" action="index"><g:message code="honorroll.title"/> </g:link></li>

                            <li><g:link controller="dns" action="index"><g:message code="dnslookup.title"/> </g:link></li>

                            <li><g:link controller="otherLogin" action="index"><g:message code="sql.injection.login.title"/> </g:link></li>

                            <li><g:link controller="credit" action="index" params="[url:'http://grydeske.net']"><g:message code="credits.title"/> </g:link></li>

                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <g:message code="helpers"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="helper" action="md5"><g:message code="md5.calculator"/> </g:link></li>
                            <li><g:link controller="helper" action="sha1"><g:message code="sha1.calculator"/> </g:link></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <g:message code="todo.app" default="TODO App"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="todoItem" action="index"><g:message code="default.list.label" args="['TODOs']"/> </g:link></li>
                            <!--
                            <li><g:link controller="todoItem" action="admin"><g:message code="todo.app.admin" default="Admin"/> </g:link></li>
                            -->
                            <sec:ifLoggedIn>
                                <g:link controller="logout" action="index"><g:message code="todo.app.logout" default="Logout"/> </g:link></li>
                            </sec:ifLoggedIn>
                        </ul>
                    </li>

                </ul>
            </div>
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

</body>
</html>
