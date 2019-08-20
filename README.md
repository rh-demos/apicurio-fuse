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

The swagger definition stub/src/spec/beer-catalog-API.json is taken from https://github.com/microcks/api-lifecycle and is the work of Laurent Broudoux & Nicolas Masse. It can be used under the license agreement stated on their git repo.
