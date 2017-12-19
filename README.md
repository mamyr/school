Cоздаем рабочую папку для проекта, например school.
Заходим в папку и инициализируем там гит репозиторий.
cd school
git init

Чтобы скачать с гитхаба нужно набрать следующие команды:
git clone git@github.com:mamyr/school.git

Нужно установить Mysql и создать базу school.
~$ mysqladmin -p -u root create school;

Запустить следующие команды для создания таблицы в базе:
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` datetime NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `userName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` datetime NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `userName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

Открываем Eclipse IDE и там File->Import->Maven->Existing Maven Projects выбираем и в окне указываем путь к папке проекта school.
Потом открываем выбранный проект и для запуска нужно чтобы сервер Apache Tomcat 9 был заранее установлен.
Нажимаем правой кнопкой мыши над проектом и выбираем Run As-> Run on Server

Ждём, когда запуститься сервер. После запуска сервера, заходим в браузере по адресу:
http://localhost:8081/school/
И видим результат.