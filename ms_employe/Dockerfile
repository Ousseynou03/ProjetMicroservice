

FROM eclipse-temurin:17-jdk-alpine
VOLUME  /tmp
ARG JAR_FILE=target/*.jar
COPY    ./target/ms_employe-0.0.1-SNAPSHOT.jar  emplapp.jar
ENTRYPOINT ["java", "-jar", "emplapp.jar"]
