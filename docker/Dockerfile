# Этап 1: сборка проекта
FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /build

RUN git clone https://github.com/SavushkinSV/demo-stub.git . && \
    mvn clean package -DskipTests

# Этап 2: финальный образ
FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get upgrade -y && \
    useradd -ms /bin/bash stub && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Копируем собранный артефакт из первого этапа
COPY --from=build /build/target/demo-stub-0.0.1-SNAPSHOT.jar ./demo-stub.jar
# Копируем jar-файл jolokia из первого этапа
COPY --from=build /build/lib/jolokia-agent-jvm-2.2.9.jar ./jolokia-agent-jvm-2.2.9.jar

HEALTHCHECK --interval=5s --timeout=10s --retries=3 \
    CMD curl -f http://localhost/ || exit 1

EXPOSE 8080 8778

USER stub

CMD ["java", "-javaagent:jolokia-agent-jvm-2.2.9.jar=port=8778,host=0.0.0.0", "-jar", "demo-stub.jar"]
