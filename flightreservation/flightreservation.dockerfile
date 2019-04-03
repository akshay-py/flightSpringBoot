FROM tomcat:8.0.20-jre8

COPY /target/flightreservation-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/flightreservation.war

## Add the wait script to the image
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.5.0/wait /wait
RUN chmod +x /wait

## Launch the wait tool and then your application
CMD /wait && /$CATALINA_HOME/bin/catalina.sh run