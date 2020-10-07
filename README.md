# spring-kafka-init


카프카를 사용하기 위해서는 zookeeper 서버 실행 후 kafka (broker) 서버가 실행되어야 한다.
docker를 실행후 `docker-compose up` 명령어를 통해 `docker-compose.yml`에 명시된 내용을 실행한다.

```yaml
# docker-compose.yml의 내용

version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"

  kafka:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 127.0.0.1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: 'false'
```

이후 Application을 구동하고 ``POST http://localhost:8081/kafka/publish?message=helloword`` 과 같은 형태로 message를 발행하면 등록된 컨슈머를 통해 메시지가 소비되는 것을 확인할 수 있다.


---
[spring boot kafka with docker](https://www.youtube.com/watch?v=-0vrqMMGQbc)
