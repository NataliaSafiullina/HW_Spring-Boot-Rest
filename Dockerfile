FROM openjdk:23

EXPOSE 8080

COPY target/HW_Spring-Boot-Rest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]