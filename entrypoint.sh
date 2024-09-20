#!/bin/sh

until nc -z postgres_db 5432; do
  echo "Waiting for PostgreSQL..."
  sleep 2
done

exec java -jar /opt/payara/payara-micro.jar \
  --deploy /opt/webapp/myapp.war \
  --contextRoot /myapp \
  --port 8081