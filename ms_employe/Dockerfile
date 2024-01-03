

FROM eclipse-temurin:17-jdk-alpine
VOLUME  /tmp
ARG JAR_FILE=target/*.jar
COPY    ./target/ms_product-0.0.1-SNAPSHOT.jar  prodapp.jar
ENTRYPOINT ["java", "-jar", "prodapp.jar"]
