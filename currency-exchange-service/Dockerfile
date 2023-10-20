FROM openjdk:17
EXPOSE 8000
ARG JAR_FILE=target/currency-exchange-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} currency-exchange-services.jar
ENTRYPOINT ["java","-jar","/currency-exchange-services.jar"]