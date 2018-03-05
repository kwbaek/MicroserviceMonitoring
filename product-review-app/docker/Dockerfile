FROM openjdk:8-jdk

VOLUME /tmp

ARG VERSION=5.3.2

RUN \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade 

RUN sh -c 'touch /app.jar'

   
ADD product-review-0.1.0.jar app.jar

EXPOSE 8500

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
