FROM openjdk:17

EXPOSE 8761
ARG JAR_FILE=target/naming-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} naming-server.jar

ENTRYPOINT ["java","-jar","/naming-server.jar"]