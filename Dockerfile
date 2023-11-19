# Use a base image with Java
FROM openjdk:17-jdk

# Set the working directory in the Docker image
WORKDIR /app

# Copy the JAR file from your Gradle build output to the Docker image
COPY build/libs/aggregator-0.0.1.jar app.jar

# Expose the port your application uses
EXPOSE 9090

# Command to run your application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
