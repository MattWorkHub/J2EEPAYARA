# Base image using Payara Micro with JDK 21
FROM payara/micro:6.2024.9-jdk21

LABEL authors="m.lattanzio"

WORKDIR /opt/webapp

COPY target/myapp.war /opt/webapp/myapp.war

COPY entrypoint.sh /opt/webapp/entrypoint.sh

EXPOSE 8081

ENTRYPOINT ["/opt/webapp/entrypoint.sh"]