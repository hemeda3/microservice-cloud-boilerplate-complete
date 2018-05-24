FROM java:openjdk-8-jdk-alpine
VOLUME /tmp
VOLUME /logs

ENV APP_JAR_NAME basic-user-webservice
ENV APP_JAR_VERSION 0.0.1
ADD ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
