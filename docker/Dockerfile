FROM openjdk:17-jdk-slim

RUN apt-get update && \
    apt-get install -y wget && \
    apt-get install -y git && \
    apt-get install -y --no-install-recommends maven && \
    useradd -ms /bin/bash stub && \
    rm -rf /var/lib/apt/lists/*
    
HEALTHCHECK --interval=5s --timeout=10s --retries=3 \
    CMD curl -f http://localhost/ || exit 1

WORKDIR /app

RUN git clone https://github.com/SavushkinSV/demo-stub.git /app && \
    mvn clean install

EXPOSE 8080 8778

USER stub

CMD ["java", "-javaagent:lib/jolokia-agent-jvm-2.2.9.jar=port=8778,host=0.0.0.0", "-jar", "target/demo-stub-0.0.1-SNAPSHOT.jar"]
