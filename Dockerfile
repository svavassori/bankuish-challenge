FROM openjdk:17-jdk-alpine3.13
LABEL maintainer="vavassori@gmail.com"

ARG JAR_FILE
COPY target/BankuishChallenge-0.1.0-SNAPSHOT.jar /opt/app.jar

ENTRYPOINT ["/opt/openjdk-17/bin/java", "-jar", "/opt/app.jar"]
