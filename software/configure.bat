cd c:\
git clone https://github.com/migueltercero/spring-boot

cd c:\spring-boot\samples
mvn clean package -DskipTests

cd c:\spring-boot\software
java -jar lombok.jar