FROM artfact-prd-vip.vmware.com:5001/bitnami/java:jdk18_222
ENV PORT 8080
EXPOSE 8080
ADD /target/userdirectory-0.0.1-SNAPSHOT.jar spring-boot-application.jar
ENTRYPOINT ["java","-jar","/spring-boot-application.jar"]