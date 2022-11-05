# Redis

## Command

```sh
docker pull redis
```

```sh
docker run --name myredis -d -p 6379:6379 redis
```

```sh
docker exec -it [CONTAINER_ID] redis-cli
```

```sh
subscribe ch1
```

```sh
publish ch1 hello
```

## Lettuce

* 구현이 간단하다.
* spring data redis 를 사용하면 lettuce 가 기본이기 때문에 별도의 라이브러리를 사용하지 않아도된다.
* spin lock 방식이기 때문에 동시에 많은 스레드가 lock 획득 대기 상태라면 redis에 부하가 걸릴 수도있다.

## Redisson

* 락 획득 재시도를 기본으로 제공
* pub - sub 방식이므로 lecttuce와 비교했을 때 redis 에 부하가 덜 간다.
* 별도의 라이브러리를 사용해야한다.
* Lock 을 라이브러리 차원에서 지원하기 때문에 사용법을 공부하여야한다.



```
재시도가 필요하지 않은 lock은 lecttuce를 활용
재시도가 필요한 경우 redisson 을 활용
```

