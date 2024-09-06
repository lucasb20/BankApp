FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . /app

RUN javac -cp .:./postgresql.jar Main.java

CMD java -cp .:./postgresql.jar Main