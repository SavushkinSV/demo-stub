## Part 4 Part 4 Docker

### 3.1 Создание Dockerfile

Создадим в директории `./docker/` файл `Dockerfile` для создания образа.

```dockerfile
FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y wget && \
    rm -rf /var/lib/apt/lists/*

RUN apt-get update && \
    apt-get install -y git && \
    apt-get install -y --no-install-recommends maven && \
    rm -rf /var/lib/apt/lists/*

RUN git clone https://github.com/SavushkinSV/demo-stub.git /app

WORKDIR /app

RUN mvn clean install

EXPOSE 8080
CMD ["java", "-javaagent:lib/jolokia-agent-jvm-2.2.9.jar", "-jar", "target/demo-stub-0.0.1-SNAPSHOT.jar"]
```

Соберём написанный докер-образ с помощью команды docker `build -t demo-stub:part4 .` при этом указав имя **demo-stub** и тег **part4**.