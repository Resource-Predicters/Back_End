FROM openjdk:11.0.16
ARG DEFAULT_PORT=80
ADD build/libs/Back_End-0.0.1-SNAPSHOT.jar /Back_End-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/Back_End-0.0.1-SNAPSHOT.jar"]


#, "--DBURL=jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project", "--DBUSER=admin", "--DBPASSWORD=qwer1234"

