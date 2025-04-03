FROM gradle:latest AS build_layer
WORKDIR /app
COPY . /app/.
RUN gradle build

FROM openjdk:latest
ENV JAR_NAME=map-storage-backend-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/app
WORKDIR $APP_HOME
COPY --from=build_layer $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME