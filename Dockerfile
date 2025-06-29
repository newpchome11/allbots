# Run tests in Chrome container
FROM selenium/standalone-chrome:latest
WORKDIR /app
USER root
COPY . .
RUN apt-get update && apt-get install -y maven
CMD ["mvn", "test"]