FROM openjdk:11-jdk-slim

RUN apt-get update && \
    apt-get install -y wget && \
    rm -rf /var/lib/apt/lists/*

RUN apt-get update && \
    apt-get install -y git && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

RUN git clone https://github.com/SavushkinSV/demo-stub.git .

WORKDIR /app/demo-stub

RUN mvn clean install

EXPOSE 8080
CMD ["java", "-javaagent:lib/jolokia-agent-jvm-2.2.9.jar", "-jar", "target/demo-stub-0.0.1-SNAPSHOT.jar"]
