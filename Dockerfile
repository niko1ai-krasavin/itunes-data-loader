#
# It copies the source code and makes jar-file
#
FROM maven:3.6.0-jdk-11-slim AS building
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

#
# It starts the jar file
#
FROM azul/zulu-openjdk-alpine:11-jre-headless
WORKDIR /opt
COPY --from=building /app/target/*.jar ./itunes-data-loader.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar"]
CMD ["/opt/itunes-data-loader.jar"]