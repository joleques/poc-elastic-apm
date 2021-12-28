FROM openjdk:11-jre-slim

WORKDIR /app

ENV TZ=America/Sao_Paulo
RUN apt-get update && \ 
    apt-get install -y --no-install-recommends tzdata curl unzip && \
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && \
    curl -sS https://infraestructure-dependencies.s3.amazonaws.com/bootstrap/linux/tzupdate-alpine.sh|sh

# App instrumentation
RUN curl -O https://repo1.maven.org/maven2/co/elastic/apm/elastic-apm-agent/1.28.3/elastic-apm-agent-1.28.3.jar
RUN mv elastic-apm-agent-1.28.3.jar elastic-apm-agent.jar

ENV COMMIT=@@commit
COPY ./build/libs .

CMD ["sh", "-c", "java -javaagent:elastic-apm-agent.jar -jar -Dspring.profiles.active=$APP_ENV gerador-nome-times.jar" ]