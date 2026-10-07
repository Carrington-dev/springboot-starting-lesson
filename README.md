# springboot-starting-lesson

## pom file
1. pom.xml (pom) file is Project Object Model file.
2. GAV → Group ID, Artifact ID and Version ID
3. Get central repository for maven project https://central.sonatype.com
4. mvnw is wrapper file that automatically download

```xml
<!--Automatic start on the server-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

### DevOps Tracker
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

```bash
/actuator/info
/actuator/health
```