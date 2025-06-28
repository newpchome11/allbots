# Stage 1: Build the Maven project
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install


# Stage 2: Run tests in Chrome container
FROM selenium/standalone-chrome:latest
USER root
COPY --from=build /app /app
WORKDIR /app
CMD ["mvn", "test"]
