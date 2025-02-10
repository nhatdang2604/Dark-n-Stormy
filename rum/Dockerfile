# Stage 1: Build the Spring Shell application using openjdk:17-alpine
FROM openjdk:17-alpine AS build

# Install Maven in the Alpine-based container
RUN apk add --no-cache maven

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# List the contents of /app/target to verify the JAR file location (for debugging)
RUN ls -l /app/target

# Stage 2: Create a runtime image
FROM openjdk:17-alpine

# Set the working directory for the runtime container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar /app/rum.jar

# Expose the port (optional, only if you need it)
EXPOSE 8081

# Define the command to run the Spring Shell application
ENTRYPOINT ["java", "-jar", "/app/rum.jar"]
