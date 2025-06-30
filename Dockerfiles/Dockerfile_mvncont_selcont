# Stage 1: Build using Maven
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run using Selenium Chrome image
FROM selenium/standalone-chrome:latest

WORKDIR /opt/selenium-tests
COPY --from=builder /build/target/*.jar selenium-tests.jar
COPY testng.xml .
COPY src/test/resources /opt/selenium-tests/resources

CMD ["java", "-cp", "selenium-tests.jar:resources", "org.testng.TestNG", "testng.xml"]