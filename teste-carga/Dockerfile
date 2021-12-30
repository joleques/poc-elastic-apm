FROM openjdk:11 as builder

WORKDIR /app

COPY . .

RUN ./gradlew build

FROM openjdk:11-jre-slim

WORKDIR /app


# App prepare
ENV TZ=America/Sao_Paulo
RUN apt-get update && \ 
    apt-get install -y --no-install-recommends tzdata curl unzip

# App instrumentation
RUN curl -O https://repo1.maven.org/maven2/co/elastic/apm/elastic-apm-agent/1.28.3/elastic-apm-agent-1.28.3.jar
RUN mv elastic-apm-agent-1.28.3.jar elastic-apm-agent.jar

COPY --from=builder ./app/build/libs .

CMD ["sh", "-c", "java -javaagent:elastic-apm-agent.jar -jar -Dspring.profiles.active=$APP_ENV teste-carga.jar" ]





