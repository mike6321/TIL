

# References

[kafka 조금 아는 척하기 1 (개발자용)](https://www.youtube.com/watch?v=0Ssx7jJJADI&list=PLkAFoI1e9O2OoBU1fmkuENsuRiiOJ4RVv&index=1&t=577s)

[kafka 조금 아는 척하기 2 (개발자용) - 프로듀서](https://www.youtube.com/watch?v=geMtm17ofPY&list=PLkAFoI1e9O2OoBU1fmkuENsuRiiOJ4RVv&index=2)

[kafka 조금 아는 척하기 3 (개발자용)- 컨슈머](https://www.youtube.com/watch?v=xqrIDHbGjOY&list=PLkAFoI1e9O2OoBU1fmkuENsuRiiOJ4RVv&index=3)

# CLI

https://kafka.apache.org/downloads

* [kafka_2.12-2.5.0.tgz](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz) ([asc](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz.asc), [sha512](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz.sha512))

------

## 로컬에서 카프카 브로커 실행

주키퍼 실행

```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```

브로커 실행

```shell
bin/kafka-server-start.sh config/server.properties
```

브로커 확인

```shell
bin/kafka-broker-api-versions.sh --bootstrap-server localhost:9092
```

토픽확인

```shell
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```

------

## kafka-topics.sh

토픽생성

```shell
 bin/kafka-topics.sh --create --bootstrap-server my-kafka:9092 --topic hello.kafka
```

토픽확인

```shell
bin/kafka-topics.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --describe
```

토픽생성 (설정지정)

```shell
bin/kafka-topics.sh --create --bootstrap-server my-kafka:9092 --partitions 10 --replication-factor 1 --topic hello.kafka2 --config retention.ms=17280000
```

토픽의 파티션 개수 변경

```shell
 bin/kafka-topics.sh --bootstrap-server my-kafka:9092 --topic test --alter --partitions 10
```

------

## kafka-configs.sh

브로커의 토픽 옵션값 변경

```shell
bin/kafka-configs.sh --bootstrap-server my-kafka:9092 --alter --add-config min.insync.replicas=2 --topic test
```

브로커의 설정된 값 확인

```shell
bin/kafka-configs.sh --bootstrap-server my-kafka:9092 --broker 0 --all --describe
```

------

## kafka-console-producer.sh

콘솔 프로듀서 실행

```shell
bin/kafka-console-producer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka
```

콘솔 프로듀서 실행 (메세지 키가 포함된 레코드 전송)

```shell
bin/kafka-console-producer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --property "parse.key=true" --property "key.separator=:"
```

------

## kafka-console-consumer.sh

메세지 값 확인

```shell
bin/kafka-console-consumer.sh \
> --bootstrap-server my-kafka:9092 \
> --topic hello.kafka \
> --from-beginning
```

메세지 키도 확인

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --property print.key=true --property key.separator="-" --from-beginning
```

메세지 키도 확인 (max 갯수 지정)

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --property print.key=true --property key.separator="-" --from-beginning --max-messages 1
```

메세지 키도 확인 (partition 지정)

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --property print.key=true --property key.separator="-" --from-beginning --partition 0
```

컨슈머 그룹 생성

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --group hello-group --from-beginning
```

토픽에 오프셋 생성 확인

```shell
 bin/kafka-topics.sh --bootstrap-server my-kafka:9092 --list
```

------

## kafka-consumer-groups.sh

컨슈머 그룹 확인

```shell
bin/kafka-consumer-groups.sh --bootstrap-server my-kafka:9092 --list
```

컨슈머 그룹 상세 확인

```shell
bin/kafka-consumer-groups.sh --bootstrap-server my-kafka:9092 --group hello-group --describe
```

<img width="1000" alt="image" src="https://user-images.githubusercontent.com/33277588/212545524-894b2791-5dda-414e-a9b4-7f86a9aa2800.png">

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic hello.kafka --group hello-group
```

<img width="1000" alt="image" src="https://user-images.githubusercontent.com/33277588/212545660-48927ccc-166c-4099-94fe-53d6fae125aa.png">

오프셋 리셋

```shell
 ✘ nhn@junuui-MacBook-Pro-16  ~/IdeaProjects/repository/kafka_2.12-2.5.0  bin/kafka-consumer-groups.sh --bootstrap-server my-kafka:9092 --group hello-group --topic hello.kafka --reset-offsets --to-earliest --execute
```

------

## 프로듀서 주요 옵션

**Required**

```shell
bootstrap.servers
```

* 프로듀서가 데이터를 전송할 대상 카프카 클러스터에 속한 브로커의 호스트이름:포트 를 1개 이상 작성
* 2개 이상의 브로커 정보를 입력하여 일부 브로커에 이슈가 발생하더라도 접속하는 데에 이슈가 없도록 설정 가능

```shell
key.serializer
```

* 레코드의 메시지 키를 직렬화하는 클래스를 지정

```shell
value.serializer
```

* 레코드의 메시지 값을 직렬화하는 클래스를 지정

**selection options**

```shell
acks
```

* 프로듀서가 전송한 데이터가 브로커들에 정상적으로 저장되었는지 전송 여부를 확인하는데 사용하는 옵션
  * 0, -1, 1 (default : 1)

```shell
linger.ms
```

* 배치를 전송하기 전까지 기다리는 최소 시간 
  * default : 0

```shell
retries
```

* 브로커로부터 에러를 받고 난 뒤 재전송을 시도하는 횟수

```shell
max.in.flight.requests.per.connection
```

* 한 번에 요청하는 최대 커넥션 개수 (default : 50)

```shell
partitioner.class
```

* 레코드를 파티션에 전송할 때 적용하는 파티셔너 클래스를 지정 (default : DefaultPartitioner)

```shell
enable.idempotence
```

* 멱등성 프로듀서로 동작할지 여부를 설정 (default : false)

```shell
transactionl.id
```

* 프로듀서가 레코드를 전송할 때 트랜잭션 단위로 묶을지 여부를 설정 (default : null)

------

## 프로듀서 주요 옵션

**Required**

```shell
bootstrap.servers
```

* 프로듀서가 데이터를 전송할 대상 카프카 클러스터에 속한 브로커의 호스트이름:포트 를 1개 이상 작성
* 2개 이상의 브로커 정보를 입력하여 일부 브로커에 이슈가 발생하더라도 접속하는 데에 이슈가 없도록 설정 가능

```
key.deserializer
```

- 레코드의 메시지 키를 역직렬화하는 클래스를 지정

```
value.deserializer
```

- 레코드의 메시지 값을 역직렬화하는 클래스를 지정

**selection options**

```shell
group.id
```

* 컨슈머 그룹 아이디를 지정
* subscribe() 로 토픽을 구독하여 사용할 때는 해당 옵션 필수 (default : null)

```shell
auto.offset.reset
```

* 컨슈머 오프셋이 없을경우 어느 오프셋부터 읽을지 선택하는 옵션 (default : latest)

```shell
enable.auto.commit
```

* 자동 커밋 / 수동 커밋

```shell
auto.commit.interval.ms
```

* 자동 커밋일 경우 오프셋 커밋 간격을 지정 (default : 5000ms)

```shell
max.poll.records
```

* poll() 메서드를 통해 반환되는 레코드 개수를 지정 (default : 500)

```shell
session.timeout.ms
```

* 컨슈머가 브로커와의 연결이 끊기는 최대 시간 (default : 10000ms)

```shell
heartbeat.interval.ms
```

* 하트비트를 전송하는 시간 간격 (default : 3000ms)

```shell
max.poll.interval.ms
```

* poll() 메서드를 호출하는 간격의 최대시간 (default : 300000ms)

```shell
isolation.level
```

* 트랜잭션 프로듀서가 레코드를 트랜잭션 단위로 보낼경우 사용

------

## Dump Log 보기

```sh
bin/kafka-dump-log.sh --deep-iteration --files data/topic02-0/00000000000000000000.log --print-data-log
```

------

## __consumer_offsets 토픽을 읽기

* __consumer_offsets : 로그에 있는 offset이 아닌 Consumer가 데이터를 읽는 당시의 offsets 이다. (로그에 기록하기 전)

<img width="1000" alt="image" src="https://user-images.githubusercontent.com/33277588/222111257-0f6cbc95-ac7b-4681-b832-f984dc858f78.png">

```sh
bin/kafka-console-consumer.sh --consumer.config ./consumer_temp.config \
--bootstrap-server my:9092 --topic __consumer_offsets \
--formatter "kafka.coordinator.group.GroupMetadataManager\$OffsetsMessageFormatter"
```

* Producer 생성

  ```sh
  bin/kafka-console-producer.sh --bootstrap-server my-kafka:9092 --topic topic01
  ```

* 컨슈머 실행 후 로그확인

  <img width="1000" alt="image" src="https://user-images.githubusercontent.com/33277588/222113669-aeb67cdc-0093-4f1a-a91d-c6d1daf5fe9e.png">

