#!/bin/bash

cp -rf /root/SpringMvc/. ${CATALINA_HOME}/webapps/SpringMvc/
cp -rf /root/tomcat-users.xml ${CATALINA_HOME}/conf/

exec ${CATALINA_HOME}/bin/catalina.sh run