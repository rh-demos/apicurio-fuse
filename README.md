---
To run
```
cd stub
mvn clean install
```
Then
```
cd ../fuse-impl
mvn spring-boot:run
```
or
```
cd ../fuse-impl
mvn clean package
java -jar target/beer-svc-impl-1.0-SNAPSHOT.jar
```
For a description of the rationale behind the project structure and why it is as it is, please refer to ./docs/blog.adoc.