FROM tomcat:jdk8-adoptopenjdk-openj9
EXPOSE 8080
CMD mkdir /temp/images/
CMD mkdir /temp/images/imagesUpload
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/*.war /usr/local/tomcat/webapps/dwi-wa.war
CMD ["catalina.sh","run"]