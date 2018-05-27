#!/bin/sh
# hack because elk was resolving to wrong IP of 198.105.244.228?
echo $(getent hosts elasticsearch) >> /etc/hosts
echo $(getent hosts elasticsearch)
until curl -s 'http://elasticsearch:9200' -o /dev/null; do
    sleep 30
done
while ! nc -z elasticsearch 9200; do sleep 5; done


#curl -XPUT "localhost:9200/_template/filebeat-1" -H 'Content-Type: application/json' -d@/etc/filebeat/filebeat.template.json
#curl -X PUT "localhost:9200/_template/filebeat-1" -H 'Content-Type: application/json' -d@/etc/filebeat/filebeat.template.json


#curl -XPUT -H 'Content-Type: application/json' http://localhost:9200/_template/filebeat-1 -d@/etc/filebeat/filebeat.template.json
#curl -XPUT -H 'Content-Type: application/json' http://localhost:9200/_template/filebeat-1 -d@/etc/filebeat/filebeat.template.json


filebeat -c /etc/filebeat/filebeat.yml -e &
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar

#DONT FOGET TO UPDATE ANY EK