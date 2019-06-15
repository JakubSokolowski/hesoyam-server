FROM openjdk:8
VOLUME /tmp
ADD build/libs/server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://hesoyam-mongo:27017/assets","-Djava.security.egd=file:/dev/./urandom", "-jar","app.jar"]