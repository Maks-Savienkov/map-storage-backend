FROM gradle:latest AS build_layer
WORKDIR /home/app
COPY --chown=gradle:gradle . .
RUN chmod +x gradlew
RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build_layer /home/app/build/libs/map-storage-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]