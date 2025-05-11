## Part 3 Метрики JVM

### 2.1

Для валидации данных добавим зависимость в файл `pom.xml`

```xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-validation</artifactId>
         <version>${spring.version}</version>
     </dependency>
```

Для валидации данных, переданных в теле запроса, добавим аннотации к полям сущности `LoginDto`:

```java
public class LoginDto {

   @NotBlank
   private String login;

   @NotNull
   @Pattern(regexp = ".{8,}")
   private String password;

   private String date;
}
```

Поле `login` не должно быть пустым или равным null. Поле `password` не должно быть равным null и должно содержать 8 или более символов.


Чтобы передать объект в валидатор, достаточно добавить аннотацию `@Valid` к параметру `dto`. Выполнение метода контроллера начнется только после успешного прохождения всех проверок:

```java
@RestController
@RequestMapping("/user")
public class StubController {

   @PostMapping()
   public ResponseEntity<?> postUser(@Valid @RequestBody LoginDto dto) {
      try {
         Thread.sleep(getDelayTime());
      } catch (InterruptedException e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      dto.setDate(currentDate);

      return new ResponseEntity<>(dto, HttpStatus.OK);
   }
    
}
```

### 2.2 Развернуть заглушку на виртуальной машине

Если на виртуальной машине не установлен Git, то с помощью команды `sudo apt install git` устанавливаем последнюю версию.

Далее с GitHub клонируем репозиторий командой `git clone https://github.com/SavushkinSV/demo-stub.git`.

![part_3_01](images/part_3_01.png "Скриншот клонированием проекта из репозитория") \
*Скриншот клонированием проекта из репозитория*

Установим последнюю версию Java Runtime Environment (JRE) на виртуальную машину. Используем команду `sudo apt install default-jre`.





Полезные ссылки:

[Валидация данных в Spring Boot](https://struchkov.dev/blog/ru/spring-boot-validation/)