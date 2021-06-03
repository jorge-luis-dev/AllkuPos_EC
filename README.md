# AllkuPos_Ec
Software POS for Ecuador, based on OpenBravo and UniCenta (POS -> Point of Sale)

## Requirements
1. Configure Java 8 https://www.allku.expert/configurar-java-home/
 , openJDK 8 not recomended
2. Configure Maven https://www.allku.expert/instalar-apache-maven/
3. Install MySQL 8 https://dev.mysql.com/downloads/

## Instruction to install
1. Clone repository
2. Get into folder
3. mysql> CREATE SCHEMA allkupos;
4. mysql> CREATE USER allku@localhost IDENTIFIED BY 'password';
5. mysql> GRANT ALL PRIVILEGES ON allkupos.* TO allku@localhost WITH GRANT OPTION;
6. mysql> flush privileges;
7. $ mvn clean
8. $ mvn install
9. Get into target folder and execute start.bat (windows)

## Compile
### Windows
`
mvn clean; mvn install; java -jar .\target\allkupos.jar
`
### GNU/Linux
`
mvn clean && mvn install && java -jar target/allkupos.jar
`

# Manual
## Printer (Epson tmu-220, Epson tm-t20 or any model) for text mode (RECOMMENDED)
### Windows
1. Install printer and share, then execute in cmd:
* C:\> net use LPT1: /delete
* C:\> net use LPT1: \\computer-name\name-shared-printer /PERSISTENT:YES
2. In Allku Pos Ec, in System -> Configuration -> Peripherals, set:
* Printer 1 -> your-printer-model
* Mode -> file
* Port -> LPT1
***
## Fonts
### GNU/Linux
* Install ttf-mscorefonts-installer package

## Set MySQL time zone
### Commands to set time zone
select version();
select now();

SET @@global.time_zone = '-05:00';
SET @@session.time_zone = '-05:00';

SELECT @@global.time_zone, @@session.time_zone;


