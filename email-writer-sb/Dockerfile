# Build stage with Java 24
FROM bellsoft/liberica-openjdk-alpine:24 AS build

WORKDIR /app
COPY . .

# Install Maven manually since this image doesn't include it
RUN apk add --no-cache maven \
    && mvn clean package -DskipTests

# Runtime stage with Java 24
FROM bellsoft/liberica-openjdk-alpine:24

WORKDIR /app
COPY --from=build /app/target/email-writer-sb-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
