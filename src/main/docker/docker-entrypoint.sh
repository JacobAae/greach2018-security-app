#!/bin/bash
set -e

exec java $APPLICATION_OPTS -Dgrails.env=$GRAILS_ENV -Dlogging.config=logback.groovy -jar application.jar $@