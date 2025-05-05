FROM eclipse-temurin:24-jdk-alpine

WORKDIR /app

COPY consumer/target/consumer-1.0-SNAPSHOT.jar consumer.jar
COPY provider/target/provider-1.0-SNAPSHOT.jar provider.jar
COPY service/target/service-1.0-SNAPSHOT.jar service.jar

ENTRYPOINT ["java", "--module-path", "consumer.jar:provider.jar:service.jar", "-m", "se.iths.webservices.spi.consumer/se.iths.webservices.consumer.Main"]
