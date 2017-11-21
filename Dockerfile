FROM openjdk:8-jre-alpine
EXPOSE 9199
ADD build/libs/ContactManager.jar /app/jars/app.jar
CMD ["java", "-jar", "/app/jars/app.jar"]
