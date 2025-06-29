# Run tests in Chrome container
FROM selenium/standalone-chrome:latest

# Set the working directory in the container
WORKDIR /app

# Set user as root
USER root

#Copying code from Linux server to docker container
COPY . .

# Install necessary dependencies (wget and unzip)
RUN apt-get update && apt-get install -y \
    wget \
    unzip

# Download and install Maven 
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.10/binaries/apache-maven-3.9.10-bin.tar.gz \
    && tar -xzvf apache-maven-3.9.10-bin.tar.gz \
    && mv apache-maven-3.9.10 /opt/maven \
    && rm apache-maven-3.9.10-bin.tar.gz
	
# Set Maven environment variables
ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

# Verify Maven installation
RUN mvn -version

#chromedriver download and making it executable
RUN wget https://storage.googleapis.com/chrome-for-testing-public/138.0.7204.49/linux64/chromedriver-linux64.zip && \
    unzip chromedriver-linux64.zip && \
	cd chromedriver-linux64 && \
    chmod +x chromedriver && \
    mv chromedriver /usr/local/bin/

CMD ["mvn", "test"]