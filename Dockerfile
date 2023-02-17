FROM amazoncorretto:11-alpine-jdk
MAINTAINER Am0
COPY target/amo-0.0.1-SNAPSHOT.jar am0.jar
ENTRYPOINT ["java","-jar","/am0.jar"]
