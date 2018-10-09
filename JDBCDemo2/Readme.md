# JDBC + Oracle + Maven
To install the ojdbc8.jar locally, use this command:
>mvn install:install-file -Dfile=/opt/sqldeveloper/jdbc/lib/ojdbc8.jar -DgroupId=com.oracle.jdbc -DartifactId=ojdbc8 -Dversion=12.0.1 -Dpackaging=jar

This allows you to include ojdbc8.jar into your pom with the dependency:
```
    <dependency>
    	<groupId>com.oracle.jdbc</groupId>
    	<artifactId>ojdbc8</artifactId>
    	<version>12.0.1</version>
    </dependency>
```

This example uses PreparedStatement in place of Statement objects in order to prevent SQLInjection attacks.
