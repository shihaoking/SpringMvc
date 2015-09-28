FROM tomcat:8.0

ADD target/SpringMvc/. /root/SpringMvc
ADD tomcat-users.xml /root/tomcat-users.xml
ADD run.sh /run.sh

RUN chmod +x /run.sh

EXPOSE 8080

CMD ["/run.sh"]