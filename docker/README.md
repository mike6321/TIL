# Docker

## Dockerfile 생성

```dockerfile
FROM openjdk:11.0.8-jre-slim
WORKDIR application
ARG JAR_FILE=target/docker*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
```



## Docker 이미지 생성

```shell
docker build -t [image_name] .
docker build -t docker_project .
```



## Docker 이미지 확인

```shell
docker images
```



## Docker 실행

```shell
docker run --rm -p 8080:8080 [image_name]
docker run --rm -p 8080:8080 docker_project
```

<img width="1707" alt="image" src="https://user-images.githubusercontent.com/33277588/174231265-c6180e20-f8e9-48c1-b034-5a9f017598e1.png">

# ETC

## DIVE 설치 및 확인

```shell
brew install dive
dive [project_name]
```

```shell
jar -xf [project_name].jar
```

## Jar 컴파일

```shell
mkdir demo
```

```shell
cp ./docker-0.0.1-SNAPSHOT.jar ./demo
```

```shell
jar -xf [project_name].jar
```

## 계층형 컴파일 (1)

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <layers>
                    <enabled>true</enabled>
                </layers>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
```

```shell
 java -Djarmode=layertools -jar target/[jar_file_name].jar list
```

```dockerfile
FROM openjdk:11.0.8-jdk-slim AS builder
WORKDIR source
ARG JAR_FILE=target/docker*.jar
COPY ${JAR_FILE} application.jar
RUN  java -Djarmode=layertools -jar application.jar extract

FROM openjdk:11.0.8-jre-slim
WORKDIR application
COPY --from=builder source/dependencies ./
COPY --from=builder source/spring-boot-loaderapplication ./
COPY --from=builder source/snapshot-dependencies ./
COPY --from=builder source/application ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
```

## 계층형 컴파일 (2) - Dockerfile 없이

```shell
mvn spring-boot:build-image
```

