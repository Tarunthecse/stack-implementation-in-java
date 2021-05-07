FROM java:8

COPY /target/stack-excercise-1.0.1.jar /opt/app/stack.jar

WORKDIR /opt/app

EXPOSE 8080

CMD ["java", "-jar", "stack.jar"]

