
FROM openjdk:17-jre-slim
WORKDIR /app
COPY target/ThymeleafMiniBankApp.jar ThymeleafMiniBankApp.jar
CMD ["java", "-jar", "ThymeleafMiniBankApp.jar"]


#FROM openjdk:17
#LABEL maintainer="javaguides.net"
#ADD target/thymeleafminibankapp-0.0.1-SNAPSHOT.jar  thymeleafminibankapp.jar
#ENTRYPOINT ["java", "-jar", "thymeleafminibankapp.jar"]

#docker build -t thymeleafminibankapp:latest .