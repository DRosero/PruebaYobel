# PruebaYobel

Para ejecutar al proyecto se debe crear un pool de conexiones en netbeans y glassfish como se muestra a continuación:

<resources>
    <jdbc-connection-pool allow-non-component-callers="false" associate-with-thread="false" connection-creation-retry-attempts="0" connection-creation-retry-interval-in-seconds="10" connection-leak-reclaim="false" connection-leak-timeout-in-seconds="0" connection-validation-method="auto-commit" datasource-classname="com.mysql.cj.jdbc.MysqlDataSource" fail-all-connections="false" idle-timeout-in-seconds="300" is-connection-validation-required="false" is-isolation-level-guaranteed="true" lazy-connection-association="false" lazy-connection-enlistment="false" match-connections="false" max-connection-usage-count="0" max-pool-size="32" max-wait-time-in-millis="60000" name="mysql_pedidos_rootPool" non-transactional-connections="false" pool-resize-quantity="2" res-type="javax.sql.DataSource" statement-timeout-in-seconds="-1" steady-pool-size="8" validate-atmost-once-period-in-seconds="0" wrap-jdbc-objects="false">
        <property name="serverName" value="localhost"/>
        <property name="portNumber" value="3306"/>
        <property name="databaseName" value="pedidos"/>
        <property name="User" value="root"/>
        <property name="Password" value="toor"/>
        <property name="URL" value="jdbc:mysql://localhost:3306/pedidos?zeroDateTimeBehavior=convertToNull"/>
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="useSSL" value="false"></property>
    </jdbc-connection-pool>
    <jdbc-resource enabled="true" jndi-name="java:module/jdbc/conexionPruebaYobel" object-type="user" pool-name="mysql_pedidos_rootPool"/>
</resources>