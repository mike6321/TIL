# References

[kafka 조금 아는 척하기 1 (개발자용)](https://www.youtube.com/watch?v=0Ssx7jJJADI&list=PLkAFoI1e9O2OoBU1fmkuENsuRiiOJ4RVv&index=1&t=577s)

[kafka 조금 아는 척하기 2 (개발자용) - 프로듀서](https://www.youtube.com/watch?v=geMtm17ofPY&list=PLkAFoI1e9O2OoBU1fmkuENsuRiiOJ4RVv&index=2)

[kafka 조금 아는 척하기 3 (개발자용)- 컨슈머](https://www.youtube.com/watch?v=xqrIDHbGjOY&list=PLkAFoI1e9O2OoBU1fmkuENsuRiiOJ4RVv&index=3)

# CLI

https://kafka.apache.org/downloads

* [kafka_2.12-2.5.0.tgz](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz) ([asc](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz.asc), [sha512](https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz.sha512))

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

