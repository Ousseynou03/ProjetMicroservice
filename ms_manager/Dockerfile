

FROM eclipse-temurin:17-jdk-alpine
VOLUME  /tmp
ARG JAR_FILE=target/*.jar
COPY    ./target/ms_manager-0.0.1-SNAPSHOT.jar  managerapp.jar
ENTRYPOINT ["java", "-jar", "managerapp.jar"]
