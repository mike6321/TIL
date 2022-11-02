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

