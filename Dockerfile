# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom and source code
COPY pom.xml .
COPY src ./src

# Build the application (skip tests if needed)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/toDoApplication-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]




## Stage 1: Build the application
#FROM maven:3.9.6-eclipse-temurin-17 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Stage 2: Run the application
#FROM eclipse-temurin:17-jre-jammy
#WORKDIR /app
#COPY --from=build /app/target/MyPersonalAssistance-1.0-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]