

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

