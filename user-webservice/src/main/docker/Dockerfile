FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV APP_JAR_NAME basic-user-webservice
ENV APP_JAR_VERSION 0.0.1

 ADD filebeat.yml /
 ADD ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]