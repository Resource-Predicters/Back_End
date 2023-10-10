#FROM openjdk:11.0.16
#ARG DEFAULT_PORT=80
#
#EXPOSE 8080
#CMD ["java", "-jar", "/Back_End-0.0.1-SNAPSHOT.jar", "--DBURL=jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project", "--DBUSER=admin", "--DBPASSWORD=qwer1234"]

WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
ADD build/libs/Back_End-0.0.1-SNAPSHOT.jar /Back_End-0.0.1-SNAPSHOT.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

#test

#    url: jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project
#    username: admin
#    password: qwer1234

#    url : ${DBURL}
#    username : ${DBUSER}
#    password : ${DBPASSWORD}