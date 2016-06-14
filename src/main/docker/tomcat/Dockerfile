FROM aschaefer/oracle_jdk:8u91

ADD hellodocker.jar hellodocker.jar

RUN sh -c 'touch /hellodocker.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/hellodocker.jar"]

EXPOSE 8009
EXPOSE 8080
