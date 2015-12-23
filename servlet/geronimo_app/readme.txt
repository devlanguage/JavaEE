--start geronimo serer 
java -jar server.jar
----To configure the default port edit the <geronimo_home>
jar -cfvm HelloWorld.war META-INF/MANIFEST.MF HelloWorld.jsp WEB-INF
--Change directory to <geronimo_home>/bin and run the following command:
--C:\software\App_Server\geronimo-tomcat6-javaee5-2.1.4\var
--sample.applications/GeronimoHelloApp/1.2/war
java -jar C:\software\App_Server\geronimo-tomcat6-javaee5-2.1.4\bin\deployer.jar --user system --password manager undeploy GeronimoHelloApp
java -jar C:\software\App_Server\geronimo-tomcat6-javaee5-2.1.4\bin\deployer.jar --user system --password manager undeploy sample.applications/GeronimoHelloApp/1.2/war
java -jar C:\software\App_Server\geronimo-tomcat6-javaee5-2.1.4\bin\deployer.jar --user system --password manager deploy HelloWorld.war