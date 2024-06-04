### Docker

```sh
docker run --name r2dbc-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=qwer -d mysql:8 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```

```sh
docker exec -it c741856a01c4 mysql -p
```

## Schema

```sql
create database fastsns;
```

```sql
use fastsns
```

```sql
create table users
(
    id         bigint auto_increment,
    name       varchar(128)                       null,
    email      varchar(255)                       null,
    created_at datetime default CURRENT_TIMESTAMP not null,
    updated_at datetime default CURRENT_TIMESTAMP not null,
    constraint users_pk
        primary key (id)
);
```

```sql
create table posts
(
    id         bigint auto_increment,
    user_id    bigint                             null,
    title      varchar(30)                        null,
    content    varchar(200)                       null,
    created_at datetime default CURRENT_TIMESTAMP not null,
    updated_at datetime default CURRENT_TIMESTAMP not null,
    constraint posts_pk
        primary key (id)
);


```

```sql
create index idx_user_id on posts (user_id);

```

