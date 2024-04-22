Для запуска приложения необходимо собрать jar файлы приложения командой в maven "mvn clean package"
После Docker Compose запустить проект с сервисами metrics-producer, consumer-service, БД consumer-db, kafka, zookeeper командой docker compose up

При запуске metrics-producer на адресе http://localhost:8080/swagger-ui/index.html# будет доступен swagger в котором можно запустить команду для отправки метрик работы приложения в kafka

При запуске consumer-service на адресе http://localhost:8081/swagger-ui/index.html# будет доступен swagger с эндпоинтами для получения метрик в БД.

Для подключения к kafka в докер контейнере серверов metrics-producer, consumer-service из IDEA необходимо указать переменную SPRING_KAFKA_BOOTSTRAP-SERVERS=localhost:9092

