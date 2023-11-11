# countLetter

## Тестовое задание.

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

### Ограничения:

В запросе необходимо указывать слово (набор символов), состоящих только из букв. Пример запроса GET:

`http://localhost:8081/api?word=aaaaabcccc`

Если в запросе будет не слово (набор символов, содержащий не только буквы), то программа вернёт сообщение с ощибкой 

`"It was not word"`

Пример выходных данных при правильном запросе:

>{

    "a": 5,
    "c": 4,
    "b": 1
    
>}

Пример выходных данных при неправильном запросе или при отсутствии параметра при запросе:

>{

    "message": "It was not word",
    "timestamp": 1699718732293
>}

### Вы можете клонировать на свой компьютер программу и опробовать или изучить её. 
  Для того, чтобы клонировать себе программу выполните следующие дествия:

1. На GitHub.com перейдите на главную страницу репозитория.

2. Над списком файлов щелкните <>Code.

3. Скопируйте URL-адрес репозитория.

   * Чтобы клонировать репозиторий по протоколу HTTPS, в разделе "HTTPS" щелкните значёк "копировать".
   * Чтобы клонировать репозиторий с помощью ключа SSH, включая сертификат, выданный центром сертификации SSH вашей организации, щелкните SSH, а затем выберите "копировать".
   * Чтобы клонировать репозиторий с помощью GitHub CLI, щелкните GitHub CLI, а затем выберите "копировать".
     
4. Откройте GIT Bash.

5. Измените текущий рабочий каталог на расположение, где должен находиться клонированный каталог.

6. Введите git clone и вставьте URL-адрес, скопированный ранее.

   >git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY

7. Нажмите клавишу ВВОД, чтобы создать локальный клон.

   >$ git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY

   >Cloning into Spoon-Knife...

   >remote: Counting objects: 10, done.

   >remote: Compressing objects: 100% (8/8), done.

   >remove: Total 10 (delta 1), reused 10 (delta 1)

   >Unpacking objects: 100% (10/10), done.