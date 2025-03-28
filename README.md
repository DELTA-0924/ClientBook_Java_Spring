# ClientBook (Java Spring)

## Описание проекта
ClientBook — это RESTful сервис телефонного справочника, разработанный на Java Spring. Проект реализует:
- CRUD-операции для управления клиентами и их телефонными номерами
- Проверку уникальности и разрешение конфликтов записей на уровне базы данных с использованием триггеров

## Технологии
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA** (работа с базой данных)
- **Oracle database** (основная СУБД)

- **Lombok** (упрощение кода)

## Установка и запуск

### 1. Клонирование репозитория
```sh
 git clone https://github.com/DELTA-0924/ClientBook_Java_Spring.git
 cd ClientBook_Java_Spring
```

### 2. Настройка окружения
- Убедитесь, что установлен **Java 17+** и **Maven**.
- В файле `application.yml` настройте параметры подключения к базе данных.

Пример `application.yml` для PostgreSQL:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/clientbook
    driver-class-name: org.postgresql.Driver
    username: your_username
    password: your_password
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
```

### 3. Сборка и запуск
Соберите и запустите проект:
```sh
mvn clean install
mvn spring-boot:run
```

После запуска API будет доступно по адресу: `http://localhost:8080`

## Логика проверки уникальности и триггеры
В проекте реализована проверка уникальности телефонных номеров и разрешение конфликтов записей на уровне базы данных с помощью **триггеров**. Это обеспечивает:
- Контроль целостности данных на уровне СУБД
- Минимизацию нагрузки на бизнес-логику приложения
- Автоматическое предотвращение дублирующих записей

Пример SQL-триггера для проверки уникальности номеров:
```sql
CREATE OR REPLACE FUNCTION prevent_duplicate_phone()
RETURNS TRIGGER AS $$
BEGIN
  IF EXISTS (
    SELECT 1 FROM clients WHERE phone = NEW.phone
  ) THEN
    RAISE EXCEPTION 'Телефонный номер уже существует';
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_phone_uniqueness
BEFORE INSERT OR UPDATE ON clients
FOR EACH ROW
EXECUTE FUNCTION prevent_duplicate_phone();
```

