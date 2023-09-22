FROM openjdk:11.0.16
ARG DBURL=jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project
ARG DBUSER=admin
ARG DBPASSWORD=qwer1234
ADD build/libs/Back_End-0.0.1-SNAPSHOT.jar /Back_End-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/Back_End-0.0.1-SNAPSHOT.jar"]

#test

#    url: jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project
#    username: admin
#    password: qwer1234

#    url : ${DBURL}
#    username : ${DBUSER}
#    password : ${DBPASSWORD}