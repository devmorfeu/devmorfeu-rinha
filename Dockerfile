FROM azul/zulu-openjdk:17-jre-latest

WORKDIR /app

COPY target/*-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]