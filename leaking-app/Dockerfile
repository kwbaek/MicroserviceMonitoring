FROM openjdk:8-jdk

VOLUME /tmp

ARG VERSION=5.3.2

RUN \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade 

COPY ClassLoaderLeakExample.java  /

RUN javac ClassLoaderLeakExample.java
CMD java -cp . ClassLoaderLeakExample 
