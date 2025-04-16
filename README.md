# Тестовое задание

Приложение работает по адресу http://localhost:8080/user.

#### Проект: Spring Framework на Java 17.

### Задачи:

Написать заглушку на java с использованием Spring и Maven.
Заглушка реализует RESTapi с двумя методами GET и POST.
1) Get выдаёт статичный json {"login":"Login1","status":"ok"} (можно использовать объект String, главное формат json);
2) Post принимает json с двумя параметрами login и password ( {"login":"...","password":".."} )
и возвращает json с login, password и текущей датой ( {"login":"...","password":"..","date":"yyyy-MM-dd HH:mm:ss"} );
3) Реализовать время отклика в заглушке 1-2 секунды.