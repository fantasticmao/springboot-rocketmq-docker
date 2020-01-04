FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app/
COPY ./${JAR_FILE} consumer.jar
CMD java -jar consumer.jar