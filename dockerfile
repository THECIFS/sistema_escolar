FROM eclipse-temurin:17-jdk
COPY target/SistemaEscolar-0.0.1-SNAPSHOT.jar java_app.jar
ENTRYPOINT ["java", "-jar", "java_app.jar"]