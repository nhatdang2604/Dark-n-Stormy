# Use OpenJDK 17 Alpine image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Install dependencies (for example, to install Maven and Git if required)
RUN apk update && apk add --no-cache bash git maven

# Copy the application code into the container
COPY . /app

# Expose the port that the Spring Boot app will run on (default 8080)
EXPOSE 8080

# Command to run the application (this could be adjusted for live reload)
CMD ["./mvnw", "spring-boot:run"]