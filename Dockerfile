FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY target/*.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/japp.jar"]