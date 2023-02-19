# **Core**

https://docs.spring.io/spring-kafka/docs/current/reference/html/#introduction

[Kafka Producer](https://jwdeveloper.notion.site/Kafka-Producer-0010f568611a42a5abaa9cc5bd3b0cd5)

* [Producer 생성](https://jwdeveloper.notion.site/Producer-3312226ab84e497ca5b40b42fc56a76f)
* [KafkaProducer send()](https://jwdeveloper.notion.site/KafkaProducer-send-98bdd0dd3ba648538b181508596b152c)
* [Partitioning](https://jwdeveloper.notion.site/Partitioning-873cdf4b1a434444b257b793ca35c495)
  * [Key 값이 없는 경우 Partitioning](https://jwdeveloper.notion.site/Key-Partitioning-18f6fbb4861041f2b6bee9673d4ab836)
  * [Key 값이 있는 경우 Partitioning](https://jwdeveloper.notion.site/Key-Partitioning-1781e83f7ea343e29f6f06ed58e72173)
* [RecordAccumulator.append()](https://jwdeveloper.notion.site/RecordAccumulator-append-a1b8634e2a5c44d6bee942344d4f8032)
  * [Recorde 사이즈 Validate](https://jwdeveloper.notion.site/Recorde-Validate-454868eabab24cdea4b22eeb3aeb56ab)
  * [First append](https://jwdeveloper.notion.site/First-append-bc7921e7bc514c058cf381d5f400c3da)
  * [Retry append](https://jwdeveloper.notion.site/Retry-append-5584fa1babec4abca0970286529fc37a)
* [Sender Thread](https://jwdeveloper.notion.site/Sender-Thread-e4d75db2c18246be967b2e6be321cb4f)

[Kafka Consumer](https://jwdeveloper.notion.site/Kafka-Consumer-e3e07ce45e6741d0bde803f05eaf191d)

* [ConsumerNetworkClient](https://jwdeveloper.notion.site/ConsumerNetworkClient-c90ea0a551a6460f88907bf434de6af4)
  * 요청 전송
    * [send](https://jwdeveloper.notion.site/send-11e90ca8f1764fa4a358ace8358482f2)
    * [compose](https://jwdeveloper.notion.site/compose-80b1a74d51b940b6a8cb2827396cd52d)
  * 응답 처리
    * [완료한 응답 적재](https://jwdeveloper.notion.site/db13207e79ec440f8a23659c98646212)
    * [pendingCompletion complete](https://jwdeveloper.notion.site/pendingCompletion-complete-65a7277fce384b83a2992addbdfd3e5d)

* [SubscriptionState](https://jwdeveloper.notion.site/SubscriptionState-86d626a043ff4fff82226bd5057ad62a)

  * [assiginment 생성](https://jwdeveloper.notion.site/assiginment-a52d04fc1f59441e99ab423a73d6c8bd)


* [ConsumerCoordinator](https://jwdeveloper.notion.site/ConsumerCoordinator-7f68d87a06b0410ab89da96aa93eadd9)
  * [리밸런스](https://jwdeveloper.notion.site/174df32e00cb475e96d73700b74b8a99)
    * [GroupCoordinator 찾기](https://jwdeveloper.notion.site/GroupCoordinator-a040e588930346acad27036a5d9bd927)
  * [Join](https://jwdeveloper.notion.site/Join-5fb63ab05d9c4d58833d512c332b4db5)
    * [JoinGroupRequest](https://jwdeveloper.notion.site/JoinGroupRequest-7ef404a80d5f457cadc19b6b717f6395)
    * [파티션 할당](https://jwdeveloper.notion.site/4565454e98ee420fa3903fa9d2dc62a2)
      * [리더설정](https://jwdeveloper.notion.site/d0b5ab69140e4a749253f7e578487a64)
      * [Assign](https://jwdeveloper.notion.site/Assign-a96a38e8ecf440b7b19c967f8615b658)
        * [consumersPerTopic 초기화](https://jwdeveloper.notion.site/consumersPerTopic-87699f85662a4a06a099156e13e5c0c0)
        * [assignment Key 초기화](https://jwdeveloper.notion.site/assignment-Key-ec9ec1312d44490d8599314693d790f9)
        * [Sorting](https://jwdeveloper.notion.site/Sorting-b995d4bbee4b4317a81bec568f1cc8bb)
        * [인덱싱을 하기위한 Param 초기화](https://jwdeveloper.notion.site/Param-52d70cea10114bdebb458e001a50324f)
        * [파티션 할당](https://jwdeveloper.notion.site/a33a458938cc4dea95bc881658e59bdf)