
FROM openjdk:20

WORKDIR /app

ENV JAVA_OPTS=""

COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/

EXPOSE 8080
EXPOSE 4200

ENTRYPOINT ["java","-jar","D387_sample_code-0.0.2-SNAPSHOT.jar"]