# Builds the User Service using Spring Boot with Docker

FROM frolvlad/alpine-oraclejdk8:slim

MAINTAINER Gary A. Stafford <garystafford@rochester.rr.com>
ENV REFRESHED_AT 2016-08-28 16:45:13

VOLUME /tmp
ADD user-service-0.1.0.jar /app.jar
RUN sh -c 'touch /app.jar' \
  && touch /user-service.log

#########################################################################################
# below from:
#   https://github.com/spujadas/elk-docker/blob/master/nginx-filebeat/Dockerfile
#   https://hub.docker.com/r/zot24/filebeat/~/dockerfile/
#########################################################################################

### install Filebeat

RUN set -ex \
  && apk --no-cache add --virtual .build-dependencies \
    curl \
  \
  && curl -fsSL http://artifacts.elastic.co/downloads/beats/filebeat/filebeat-6.2.4-linux-x86_64.tar.gz -o /tmp/filebeat.tar.gz \
  \
  && cd /tmp \
  && echo " install" -c - \
  && tar -xzf filebeat.tar.gz \
  \
  && cd filebeat-* \
  && cp filebeat /bin \
  \
  && rm -rf /tmp/filebeat*
  # \
  # && apk del .build-dependencies

### configure Filebeat
# config file
ADD filebeat.yml /etc/filebeat/filebeat.yml
ADD filebeat.template.json /etc/filebeat/filebeat.template.json

# CA cert

### start Filebeat
ADD start.sh /usr/local/bin/start.sh
RUN chmod +x /usr/local/bin/start.sh
CMD [ "/usr/local/bin/start.sh" ]
