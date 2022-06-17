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

