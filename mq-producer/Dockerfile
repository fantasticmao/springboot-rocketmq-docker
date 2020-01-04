FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app/
COPY ./${JAR_FILE} producer.jar
EXPOSE 8080
CMD java -jar producer.jar