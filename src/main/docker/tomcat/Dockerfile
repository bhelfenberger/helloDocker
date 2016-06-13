FROM centos:centos7
MAINTAINER Beat Helfenberger <beat.helfenberger@namics.com>

RUN yum update -y

# install base tools
RUN yum install -y wget unzip

#install Oracle JRE
ENV JDK_VERSION 8u91
RUN wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/$JDK_VERSION-b14/jre-$JDK_VERSION-linux-x64.rpm"
RUN rpm -ivh jre-$JDK_VERSION-linux-x64.rpm && rm jre-$JDK_VERSION-linux-x64.rpm

# install Oracle JCE Strong Security
RUN wget "http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip" --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie"
RUN unzip -oj  jce_policy-8.zip -d /usr/java/default/lib/security


ADD hellodocker.jar hellodocker.jar

RUN sh -c 'touch /hellodocker.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/hellodocker.jar"]

EXPOSE 8009
EXPOSE 8080
