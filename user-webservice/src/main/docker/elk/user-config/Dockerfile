FROM docker.elastic.co/beats/filebeat:7.0.0-alpha1
COPY filebeat.yml /usr/share/filebeat/filebeat.yml
COPY filebeat.yml /usr/share/filebeat/filebeat.template.json

USER root
RUN chown filebeat /usr/share/filebeat/filebeat.yml
USER filebeat