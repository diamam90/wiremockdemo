FROM eclipse-temurin:17-alpine
COPY target/wiremockDemo-1.0-SNAPSHOT.jar wiremockDemo.jar
ENTRYPOINT ["java","-jar","wiremockDemo.jar"]