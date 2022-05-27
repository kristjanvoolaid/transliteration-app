FROM openjdk:17

WORKDIR /app

ARG JAR_LOCATION=build/libs

ADD $JAR_LOCATION/*.jar /app/

CMD java -jar -Dspring.profiles.active=transliteration-web transliteration-app-build.jar
