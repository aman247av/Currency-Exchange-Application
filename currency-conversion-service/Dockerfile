FROM openjdk:17

EXPOSE 8100
ARG JAR_FILE=target/currency-conversion-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} currency-conversion-service.jar

ENTRYPOINT ["java","-jar","/currency-conversion-service.jar"]