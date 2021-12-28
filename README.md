# APM (Application Performance Monitoring): #
É a ferramenta da Elastic que ajuda a observar os serviços de nossas aplicações, baseando-se nos 3 pilares da Observabiidade (Log, Metrica e Trace)

Objetivo dessa POC foi montar a stack da Elastic necessaria para usarmos o APM.
Foram desenvildos 3 serviços Java para realizar os testes.

# API de Teste: #
Inicializando a Stack:
```
docker-compose up -d
```
Para testar o uso:

```
URL: http://localhost:8000/gerador/nome-time/<codigo-time>
method: GET
<codigo-time>: de 1 a 4 para teste

```

Acessar o Kibana:
```
http://localhost:5601/
```

# Dependências: #

 - Java 11
 - Spring 2.4.2
 - Gradle
 - Docker

# Referências: #
 - [Introdução sobre APM](https://www.youtube.com/watch?v=5Ylg_08HFqw&t=5s)
 - [Elastic APM](https://www.elastic.co/pt/observability)
