FROM openjdk:8-jdk

VOLUME /tmp

ARG VERSION=5.3.2

RUN \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade 

RUN apt-get install libpcap0.8

RUN curl -L -O https://artifacts.elastic.co/downloads/beats/packetbeat/packetbeat-5.3.2-amd64.deb \
    && dpkg -i packetbeat-5.3.2-amd64.deb && apt-get install -y supervisor
 
RUN sh -c 'touch /app.jar'

   
ADD product-detail-0.1.0.jar app.jar
ADD supervisord.conf /etc/supervisor/conf.d/supervisord.conf
ADD packetbeat.yml packetbeat.yml

RUN mv packetbeat.yml /etc/packetbeat/packetbeat.yml
RUN chmod 755 /etc/packetbeat/packetbeat.yml

ENTRYPOINT ["/usr/bin/supervisord"]

