FROM amazoncorretto:17-alpine3.14
MAINTAINER Am0
COPY target/amo-0.0.1-SNAPSHOT.jar am0-app.jar
ENTRYPOINT ["java","-jar","/am0-app.jar"]
