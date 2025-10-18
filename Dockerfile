# --------- STAGE 1: Build ----------
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

COPY gradlew ./
COPY gradle gradle
RUN chmod +x gradlew

# ⬇️ Use Groovy DSL files
COPY settings.gradle .
COPY build.gradle .

# (Optional) COPY gradle.properties only if you actually have it
# COPY gradle.properties .

RUN ./gradlew --no-daemon dependencies || true
COPY src src
RUN ./gradlew clean bootJar -x test --no-daemon

# --------- STAGE 2: Runtime ----------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
