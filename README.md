# Autocomplete
! На данный момент задача не полностью решена, нет логики с группировкой и 
отношениями &(И) и ||(ИЛИ).

Для установки требуется запустить команды: mvn clean package
Для запуска требуется команда: java -jar .\target\Autocomplete-1.0-SNAPSHOT.jar

Крайне не рекомендуется менять файл airport.csv, и если менять файл, то
внутри файла должна быть такая же сигнатура, как и в оригинале. 

Путь к файлу указан в файле application.yaml по пути 
src/main/resources/application.yaml

## Личное мнение
Задание интересно, редко такие делал. Код получился громоздкий и не думаю, 
что смогу пройти, но спасибо за интересную задачу. Теперь понимаю, где мои слабые места и 
что надо подучить и потренироваться делать.

## Нефункциональные требования
### Выполненые
* Создавать новые файлы или редактировать текущий нельзя.
  В том числе использовать СУБД. (Не менял и не редактировал бд).
* Для корректной работы программе требуется не более 7 МБ памяти.
  Все запуски java –jar должны выполняться с jvm флагом -Xmx7m.
  (Программа корректно отрабатывал с флагом -Xmx7m).
* Должны соблюдаться принципы ООП и SOLID. 
  (Постарался соблюсти принципы ООП и SOLID).
* Скорость поиска должна быть максимально высокой с учетом требований выше.
  В качестве ориентира можно взять число из скриншота выше: на поиск по «Bo», который
  выдает 68 строк, требуется 25 мс, поиск по «Bower», который выдает 1 строку без
  фильтров 5 мс. (Скорость поиска относительно быстрая)
* Ошибочные и краевые ситуации должны быть корректно обработаны. 
  (Так же постарался обработать все возможные события).
### Невыполненные
* Перечитывать все строки файла при каждом поиске нельзя.
  В том числе читать только определенную колонку у каждой строки.
  (Не представляю, как это возможно)
* Хранить весь файл в памяти нельзя.
  Не только в качестве массива байт, но и в структуре, которая так или иначе содержит все
  данные из файла. (Решил сделать по другому + также не представляю как это возможно)
* Сложность поиска меньше чем O(n), где n число строк файла. (Не успел по времени)
* Использовать готовые библиотеки для парсинга CSV формата нельзя. 
  (Использовал библиотеку, так как была проблема с парсером)
