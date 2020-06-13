# our base build image
FROM maven:3-jdk-11 as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn assembly:assembly

# our final base image
FROM openjdk:11-jre-slim-buster

# set deployment directory
WORKDIR /my-project

# copy over the built artifact from the maven image
COPY --from=maven target/calc-1.0-SNAPSHOT-jar-with-dependencies.jar ./

# set the startup command to run your binary
CMD ["java", "-jar", "calc-1.0-SNAPSHOT-jar-with-dependencies.jar"]