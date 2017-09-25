springboot jar running command:
mvn clean install


running this jar  
java -jar  -Dspring.profiles.active=envName   XXX.jar 
if you run on backstage you can 
nohup java -jar  -Dspring.profiles.active=envName   XXX.jar &
if you dont know nohup  ,please you  man nohup in commandsearch on website or