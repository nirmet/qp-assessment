FROM maven:3.6.3-openjdk-17-slim AS build
WORKDIR /home/app
COPY . /home/app/
RUN mvn clean package

FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY --from=build /home/app/target/GroceryApp.jar /GroceryApp.jar
ENTRYPOINT ["java", "-jar", "/GroceryApp.jar"]
